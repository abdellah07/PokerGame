package casino.player;

import java.util.List;

public enum Token {
    BLACK(100),BLUE(50),GREEN(20),RED(10),WHITE(5);

    private int price;

    Token(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
