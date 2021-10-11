public class Card {

    private CardType cardType;
    private String value;

    Card(CardType cardType, String value){
        this.cardType = cardType;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{ "+ value +" "+ cardType + " }";
    }
}
