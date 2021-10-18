package casino.player;

public class Bot extends Player{
    public Bot(String firstName, String secondName, String email) {
        super(firstName, secondName, email);
    }

    public boolean play(){
        if (hand.getTotal() < 17)
            return true;
        return false;
    }
}
