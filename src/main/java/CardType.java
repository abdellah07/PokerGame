public enum CardType {
    COEUR("COEUR"),PIQUE("PIQUE"),TREFLE("TREFLE"),CARREAU("CARREAU");

    String name;

    CardType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
