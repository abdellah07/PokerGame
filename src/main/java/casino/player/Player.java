package casino.player;

import casino.cards.Card;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String firstName;

    private String secondName;

    private String email;

    private Hand hand;

    private int cash;

    private List<Pair<Token,Integer>> tokens;

    public Player(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.hand = new Hand();
        initialisationTokens();
    }

    private void initialisationTokens(){
        tokens = new ArrayList<>();
        int copyOfCash = cash;
        for (Token token: Token.values()) {
            int tokenNumber = copyOfCash/token.getPrice();
            tokens.add(Pair.of(token, tokenNumber));
            copyOfCash-=tokenNumber*token.getPrice();
        }
    }

    public int getTotal(){
        return hand.getTotal();
    }

    public List<Pair<Token,Integer>> getTokens(){
        List<Pair<Token,Integer>> copyOfTokens = new ArrayList<>(tokens);
        return copyOfTokens;
    }

    public void addCardToHand(Card card){
        hand.addCard(card);
    }

    public String getName(){
        return secondName+" "+firstName;
    }

    public String showCards(){
        return hand.toString()+" ";
    }

    @Override
    public String toString() {
        return firstName+" "+secondName+" have "+hand.getCards().size();
    }
}
