/**
 * this enum represent all the card types
 * @author Abdellah NAJI
 * @version 0.1
 */
public enum CardType {
    COEUR("COEUR"),PIQUE("PIQUE"),TREFLE("TREFLE"),CARREAU("CARREAU");

    /**
     * string that represent the type of the card
     */
    private String name;

    CardType(String name){
        this.name = name;
    }

    /**
     *
     * @return the String representing the card type
     */
    public String getName() {
        return name;
    }
}
