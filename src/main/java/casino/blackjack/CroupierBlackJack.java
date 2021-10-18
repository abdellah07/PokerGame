package casino.blackjack;

import casino.player.Croupier;
import casino.player.Hand;
import static casino.util.ConsoleColor.*;


public class CroupierBlackJack extends Croupier {
    Hand hand;

    protected CroupierBlackJack(){
        cardManager = new CardManagerBJ();
        hand = new Hand();
    }

    protected void takeCards(){
        hand.addCard(cardManager.getCard());
        hand.addCard(cardManager.getCard());
        showOneCard();

    }

    private void showOneCard(){

        System.out.println(GREEN+"## The dealer have ".toUpperCase()+BLUE+hand.getCards().get(0)+GREEN+" and a hidden card.".toUpperCase()+RESET);
    }

    protected int getTotalValue(){
        return hand.getTotal();
    }

    protected String getStats(){
        return hand.toString()+". Total Value "+getTotalValue();
    }
}
