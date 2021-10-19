package casino.blackjack;

import casino.cards.Card;
import casino.player.Croupier;
import casino.player.Hand;
import casino.player.Player;

import java.util.List;
import java.util.OptionalDouble;
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
        if(IoBlackJack.getShow())
            System.out.println(GREEN+"## Player ".toUpperCase()+BLUE+player.getName()+GREEN+" picked ".toUpperCase()+BLUE+ card + GREEN+". Total Value is ".toUpperCase()+BLUE+player.getTotal()+RESET);
    }

    protected void takeCards(){
        pickCard();
        pickCard();
        showOneCard();
    }

    private void pickCard(){
        Card card = cardManager.getCard();
        hand.addCard(card);
        if(IoBlackJack.getShow())
            System.out.println(GREEN+"## ".toUpperCase()+BLUE+"Dealer "+GREEN+"picked ".toUpperCase()+BLUE+ card + GREEN+". Total Value is ".toUpperCase()+BLUE+getTotalValue()+RESET);

    }

    private void showOneCard(){
        IoBlackJack.showOneCard(hand);
    }

    protected void play(List<Player> players){
            OptionalDouble max = players.stream().filter(player -> player.getTotal() < 21).mapToInt(Player::getTotal).average();
            if(max.isPresent()){
                while(getTotalValue()<17 && getTotalValue()<max.getAsDouble()){
                    pickCard();
                }
            }
    }

    protected int getTotalValue(){
        return hand.getTotal();
    }

    protected String getStats(){
        return hand.toString()+GREEN+". Total Value "+BLUE+getTotalValue()+RESET;
    }
}
