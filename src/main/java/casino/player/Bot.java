package casino.player;

public class Bot extends Player{
    private int maxNumber;
    public Bot(String firstName, String secondName, String email) {
        super(firstName, secondName, email);
        maxNumber=17;
    }

    public Bot(String firstName, String secondName, String email,int maxN) {
        super(firstName, secondName, email);
        maxNumber=maxN;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public boolean play(){
        if (hand.getTotal() < maxNumber)
            return true;
        return false;
    }
}
