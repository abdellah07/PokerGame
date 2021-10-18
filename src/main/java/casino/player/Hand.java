package casino.player;

import casino.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int total;

    public Hand(){
        cards = new ArrayList<>();
        total = 0;
    }

    public List<Card> getCards() {
        List<Card> copyOfCards = new ArrayList(cards);
        return copyOfCards;
    }

    public int getTotal() {
        return total;
    }



    public void addCard(Card card){
        cards.add(card);
        if(card.intValue() == 14 && total+card.intValue()>21)
            total++;
        else if(card.intValue()>=10)
            total+=10;
        else
            total+=card.intValue();
    }

    public void sortCards(){
        Collections.sort(cards);
    }


    @Override
    public String toString() {
        return "cards " + cards;
    }
}
