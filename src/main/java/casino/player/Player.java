package casino.player;

import casino.cards.Card;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static casino.util.ConsoleColor.*;

public class Player {

    protected String firstName;

    protected String secondName;

    protected String email;

    protected Hand hand;

    protected int cash;

    protected List<Pair<Token,Integer>> tokens;

    public Player(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.hand = new Hand();
        initialisationTokens();
    }

    public void initialization(){
        this.hand = new Hand();
    }
    protected void initialisationTokens(){
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

    public Card addCardToHand(Card card){
        hand.addCard(card);
        return card;
    }

    public String getName(){
        return secondName+" "+firstName;
    }

    public String showCards(){
        return hand.toString()+" ";
    }

    public boolean checkAs(){
        return hand.verifiesAs();
    }

    @Override
    public String toString() {
        return firstName+" "+secondName+" have "+hand.getCards().size();
    }

    public boolean play(){
        System.out.print(GREEN+"## Player ".toUpperCase()+BLUE+getName()+GREEN+" Do you want to pull a card. (y/n)".toUpperCase()+RESET+"\t:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(s.toUpperCase().equals("Y"))
            return true;
        else
            return false;
    }
}
