package casino.player;

import casino.cards.CardManager;
import casino.cards.CardManagerImpl;
import casino.player.Player;

public class Croupier {
    protected CardManager cardManager;

    public Croupier(){
        cardManager = new CardManagerImpl();
    }

    public void giveCardTo(Player player){
        player.addCardToHand(cardManager.getCard());
    }

    public void giveCardTo(Player player,int amount){
        for (int i = 0; i < amount; i++) {
            player.addCardToHand(cardManager.getCard());
        }
    }

    public int getCardsLeft(){
        return cardManager.numberOfCardsLeft();
    }




}
