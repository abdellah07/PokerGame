package casino.cards;

import org.apache.commons.lang3.tuple.Pair;

public class Card implements Comparable<Card>{

    private CardType cardType;
    private String value;

    Card(CardType cardType, String value){
        this.cardType = cardType;
        this.value = value;
    }

    public CardType getCardType() {
        return cardType;
    }

    public Pair<CardType,String> getValue() {
        return Pair.of(cardType,value);
    }

    public int intValue(){
        return AllowedValues.getIntValue(value);
    }

    @Override
    public String toString() {
        return "{ "+ value +" "+ cardType + " }";
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.intValue(),o.intValue());
    }
}
