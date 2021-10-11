import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String firstName;

    private String secondName;

    private String email;

    private Hand hand;

    private List<Pair<Token,Integer>> tokens;

    private List<Pair<Token,Integer>> tokensInTable;

    public Player(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.hand = new Hand();
        initialisationTokens();
        initialisationTokensInTable();
    }

    private void initialisationTokens(){
        tokens = new ArrayList<>();
        for (Token token: Token.values())
            tokens.add(Pair.of(token,0));
    }

    private void initialisationTokensInTable(){
        tokensInTable = new ArrayList<>();
        for (Token token: Token.values())
            tokensInTable.add(Pair.of(token,0));
    }

    public List<Pair<Token,Integer>> getTokens(){
        List<Pair<Token,Integer>> copyOfTokens = new ArrayList<>(tokens);
        return copyOfTokens;
    }

    public void addCardToHand(Card card){
        hand.addCard(card);
    }


    @Override
    public String toString() {
        return firstName+" "+secondName+" have "+hand.getCards().size();
    }
}
