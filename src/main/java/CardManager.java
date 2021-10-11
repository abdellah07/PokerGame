import Exceptions.NotAllowedValueException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardManager {
    private List<Card> deck;

    CardManager(){
        deck = new ArrayList<>();
        generateDeck();
    }

    private void generateDeck(){
        for (CardType type:CardType.values())
            for(int i = AllowedValues.getMinValueAllowed(); i<=AllowedValues.getMaxValueAllowed(); i++)
                try {
                    deck.add(new Card(type,AllowedValues.getValue(i)));
                }catch (NotAllowedValueException e){
                    // il y'aura jamais d'exeption dans ce scope
                }
    }

    public int numberOfCards(){
        return deck.size();
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
        Collections.shuffle(deck);
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
