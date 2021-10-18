package casino.util;

import casino.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static casino.util.ConsoleColor.*;

public class StatsCollector {
    int dealerWin;
    List<Player> players;
    int values[];


    public StatsCollector(List<Player> players){
        this.players = new ArrayList<>(players);
        values = new int[players.size()];
    }

    public void collect(List<Player> winners){
        for (int i = 0; i < players.size(); i++) {
            if(winners.contains(players.get(i)))
                values[i]++;
        }
    }

    public void Percentage(int n) {
        for (int value :values) {
            Double d = ((double)value/n)*100;
            System.out.println(GREEN+" "+value +BLUE+" --> "+RED+d+RESET);
        }
    }

    @Override
    public String toString() {
        return "StatsCollector{" +
                "dealerWin=" + dealerWin +
                ", players=" + players +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
