package casino.blackjack;

import casino.cards.Card;
import casino.player.Croupier;
import casino.player.Hand;
import casino.player.Player;

import java.util.List;
import java.util.OptionalInt;

import static casino.util.ConsoleColor.*;


public class CroupierBlackJack extends Croupier {
    Hand hand;

    protected CroupierBlackJack(){
        cardManager = new CardManagerBJ();
        hand = new Hand();
    }

    @Override
    public void giveCardTo(Player player) {
        Card card = cardManager.getCard();
        player.addCardToHand(card);
        System.out.println(GREEN+"## Player ".toUpperCase()+BLUE+player.getName()+GREEN+" picked ".toUpperCase()+BLUE+ card + GREEN+". Total Value is ".toUpperCase()+BLUE+player.getTotal()+RESET+"\n");
    }

    protected void takeCards(){
        pickCard();
        pickCard();
        showOneCard();
    }

    private void pickCard(){
        Card card = cardManager.getCard();
        hand.addCard(card);
        System.out.println(GREEN+"## ".toUpperCase()+BLUE+"Dealer "+GREEN+"picked ".toUpperCase()+BLUE+ card + GREEN+". Total Value is ".toUpperCase()+BLUE+getTotalValue()+RESET+"\n");

    }

    private void showOneCard(){
        System.out.println(GREEN+"## The dealer have ".toUpperCase()+BLUE+hand.getCards().get(0)+GREEN+" and a hidden card.".toUpperCase()+RESET);
    }

    protected void play(List<Player> players){
            OptionalInt max = players.stream().filter(player -> player.getTotal() < 21).mapToInt(Player::getTotal).max();
            if(max.isPresent()){
                while(getTotalValue()<17 && getTotalValue()<max.getAsInt()){
                    pickCard();
                }
            }
    }

    protected int getTotalValue(){
        return hand.getTotal();
    }

    protected String getStats(){
        return hand.toString()+". Total Value "+getTotalValue();
    }
}
