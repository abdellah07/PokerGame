import java.util.List;

public class Game {
    private Croupier croupier;
    private Player[] players;

    Game(Player ... players){
        croupier = new Croupier();
        this.players = players;

    }

    private void giveTwoCardsToEach(){
        for(int i= 0; i< players.length; i++){
            for (int j = 0; j < 2; j++) {
                croupier.giveCardTo(players[i]);
            }
        }
    }

}
