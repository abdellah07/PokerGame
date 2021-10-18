package casino.player;

import casino.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {
    private List<Card> cards;
    private int total;
    private boolean as;

    public Hand(){
        cards = new ArrayList<>();
        total = 0;
        as = false;
    }

    public List<Card> getCards() {
        List<Card> copyOfCards = new ArrayList(cards);
        return copyOfCards;
    }

    public int getTotal() {
        return total;
    }


    public boolean verifiesAs(){
        if(total>21)
            if(!cards.stream().filter(card -> card.getValue().getValue().equals("A")).collect(Collectors.toList()).isEmpty() && as) {
                total -= 10;
                return true;
            }
        return false;
    }

    public void addCard(Card card){
        cards.add(card);
        if(card.intValue() == 14 && total+card.intValue()>21) {
            total++;
        }else if(card.intValue() == 14) {
            total += 11;
            as = true;
        }else if(card.intValue()>=10)
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
