

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardManagerImpl implements CardManager {
    private List<Card> deck;

    public CardManagerImpl(){
        deck = new ArrayList<>();
        generateDeck();
    }

    private void generateDeck(){
        for (CardType type:CardType.values())
            for(int i = AllowedValues.getMinValueAllowed(); i<=AllowedValues.getMaxValueAllowed(); i++) {
                deck.add(new Card(type, AllowedValues.getValue(i)));
            }
    }

    @Override
    public int numberOfCardsLeft(){
        return deck.size();
    }

    private void shuffleDeck(){
        Collections.shuffle(deck);
        Collections.shuffle(deck);
    }

    @Override
    public Card getCard(){
        shuffleDeck();
        return !deck.isEmpty()?deck.get(0):null;
    }

    @Override
    public String toString() {
        String s="";
        for (Card card: deck) {
            s+= card.toString()+" ";
        }
        return "Deck : " + s;
    }
}
