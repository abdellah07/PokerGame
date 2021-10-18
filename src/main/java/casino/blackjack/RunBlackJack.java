package casino.blackjack;

import casino.player.Bot;
import casino.player.Croupier;
import casino.player.Player;
import casino.util.StatsCollector;

import java.util.*;
import java.util.stream.Collectors;

import static casino.util.ConsoleColor.*;

public class RunBlackJack {
    private List<Player> players;
    private CroupierBlackJack croupier;
    private List<Player> winners;
    private List<Player> losers;
    private List<Player> equality;



    RunBlackJack(){
        players = new ArrayList<>();
        croupier = new CroupierBlackJack();
        System.out.println(CYAN+"##### Welcome To The New Casino ##### \n".toUpperCase()+RESET);
        System.out.println(CYAN+"  ########### Black Jack ##########   \n".toUpperCase()+RESET);

        winners = new ArrayList<>();
        losers = new ArrayList<>();
        equality = new ArrayList<>();
    }

    private void addPlayer(Player player){
        System.out.println(GREEN+"## "+BLUE+player.getName()+" Joined the Game".toUpperCase()+RESET);
        players.add(player);
    }

    private void initCroupier(){
        croupier.takeCards();
    }

    private void initPlayers(){
        for (Player player: players) {
            player.initialization();
            croupier.giveCardTo(player,2);
            showPlayerStats(player);
        }
    }

    public void initGame(){
        System.out.println("###############################################################################################");
        initPlayers();
        initCroupier();
        System.out.println("###############################################################################################");
    }

    private void showPlayerStats(Player player){
        System.out.println(GREEN+"## Player ".toUpperCase()+BLUE+player.getName()+GREEN+" have ".toUpperCase()+BLUE+player.showCards() + GREEN+". Total Value is ".toUpperCase()+BLUE+player.getTotal()+RESET);
    }

    public List<Player> start(){
        playersPlay();
        List<Player> playerIn = players.stream().filter(player -> player.getTotal()<21).collect(Collectors.toList());
        List<Player> playersStilIn = players.stream().filter(player -> player.getTotal() < 21).collect(Collectors.toList());
        if(!playersStilIn.isEmpty())
            croupier.play(playersStilIn);
        return analyseParty(playersStilIn);
    }

    List<Player> analyseParty(List<Player> playersStilIn){
        if(playersStilIn.isEmpty()) {
            if (winners.isEmpty())
                System.out.println(GREEN + "## " + RED + " \t everyone lost".toUpperCase() + RESET);
        }else {
            if(croupier.getTotalValue()<=21){
                System.out.println(GREEN +"##"+BLUE+ "Dealer "+croupier.getStats());
                winners.addAll(playersStilIn.stream().filter(player -> player.getTotal()>croupier.getTotalValue()).collect(Collectors.toList()));
                equality.addAll(playersStilIn.stream().filter(player -> player.getTotal()==croupier.getTotalValue()).collect(Collectors.toList()));
                losers.addAll(playersStilIn.stream().filter(player -> player.getTotal()<croupier.getTotalValue()).collect(Collectors.toList()));
            }else{
                System.out.println(GREEN + "## " + RED + " \t Dealer lost".toUpperCase() + RESET);
                winners.addAll(playersStilIn);
            }
        }



        if(!winners.isEmpty()) {
            System.out.println("\n" + GREEN + "## " + PURPLE + " \t Winners".toUpperCase()+GREEN+" are :".toUpperCase() + RESET);
            for (Player winner : winners)
                System.out.println(GREEN + "## \t" + PURPLE + "\t\t\t" + winner.getName() + RESET);
        }

        if(!equality.isEmpty()) {
            System.out.println("\n" + GREEN + "## " + PURPLE + " \t Equality :".toUpperCase()+GREEN+" are :".toUpperCase() + RESET);
            for (Player equal : equality)
                System.out.println(GREEN + "## \t" + BLUE + "\t\t\t" + equal.getName() + RESET);
        }

        if(!losers.isEmpty()) {
            System.out.println("\n" + GREEN + "## " + PURPLE + " \t Losers :".toUpperCase()+GREEN+" are :".toUpperCase() + RESET);
            for (Player loser : losers)
                System.out.println(GREEN + "## \t" + RED + "\t\t\t" + loser.getName() + RESET);
        }
        return winners;
    }

    private void playersPlay(){
        for (Player player: players) {
            System.out.println(YELLOW+"############################# MOVE TO PLAYER "+player.getName()+" ############################# \n"+RESET);
            boolean end = false;
            while (!end) {
                showPlayerStats(player);
                if(player.play()) {
                    croupier.giveCardTo(player);
                    System.out.println();
                    if (checkPlayerStats(player))
                        end = true;
                }else {
                    end = true;
                    System.out.println();
                }
            }
        }
    }


    private boolean checkPlayerStats(Player player){
        if(player.getTotal() == 21) {
            System.out.println(GREEN + "## " + PURPLE + " $$ BINGO BLACK JACK $$ ".toUpperCase() + BLUE + player.getName() + PURPLE + " WON ".toUpperCase() + RESET+"\n");
            winners.add(player);
            return true;
        }
        else if(player.getTotal() > 21 && !player.checkAs()) {
            System.out.println(GREEN + "## " + RED + " YOU LOST " + RESET+"\n");
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        boolean bot = true;

        if(!bot) {
            RunBlackJack blackJack = new RunBlackJack();
            blackJack.addPlayer(new Player("NAJI", "Abdellah", "abdellah@mail.com"));
            blackJack.addPlayer(new Player("KHERRAF", "Taha", "Taha@mail.com"));
            blackJack.addPlayer(new Player("JADAR", "Mohammed", "Mohammed@mail.com"));
            System.out.println();
            blackJack.initGame();
            System.out.println();
            blackJack.start();
        }else {
            int NBBOUCLE = 50000;
            Player p[] = {new Bot("NAJI", "Abdellah", "abdellah@mail.com")
                    ,new Bot("KHERRAF", "Taha", "Taha@mail.com")
                    ,new Bot("JADAR", "Mohammed", "Mohammed@mail.com")};
            StatsCollector s = new StatsCollector(Arrays.asList(p));
            for (int i = 0; i < NBBOUCLE; i++) {
                RunBlackJack blackJack = new RunBlackJack();
                blackJack.addPlayer(p[0]);
                blackJack.addPlayer(p[1]);
                blackJack.addPlayer(p[2]);
                System.out.println();
                blackJack.initGame();
                System.out.println();
                s.collect(blackJack.start());
            }

            s.Percentage(NBBOUCLE);

        }


    }
}
