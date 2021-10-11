import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        List<Card> copyOfCards = new ArrayList(cards);
        return copyOfCards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void sortCards(){
        Collections.sort(cards);
    }

}
