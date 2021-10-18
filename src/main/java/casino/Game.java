package casino;

import casino.player.Croupier;
import casino.player.Player;

public class Game {
    private Croupier croupier;
    private Player[] players;

    public Game(Player ... players){
        croupier = new Croupier();
        this.players = players;
        giveTwoCardsToEach();
    }

    private void giveTwoCardsToEach(){
        for(int i= 0; i< players.length; i++){
            for (int j = 0; j < 2; j++) {
                croupier.giveCardTo(players[i]);
            }
        }
    }

}
