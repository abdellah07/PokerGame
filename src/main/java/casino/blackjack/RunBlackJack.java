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
        IoBlackJack.startMenu();
        winners = new ArrayList<>();
        losers = new ArrayList<>();
        equality = new ArrayList<>();
    }

    private void addPlayer(Player player){
        IoBlackJack.playerJoined(player);
        players.add(player);
    }

    private void initCroupier(){
        croupier.takeCards();
    }

    private void initPlayers(){
        for (Player player: players) {
            player.initialization();
            croupier.giveCardTo(player,2);
            IoBlackJack.showStats(player);
        }
    }

    public void initGame(){
        IoBlackJack.separator();
        initPlayers();
        initCroupier();
        IoBlackJack.separator();
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
                IoBlackJack.everyOneLost();
        }else {
            if(croupier.getTotalValue()<=21){
                IoBlackJack.showStats(croupier);
                winners.addAll(playersStilIn.stream().filter(player -> player.getTotal()>croupier.getTotalValue()).collect(Collectors.toList()));
                equality.addAll(playersStilIn.stream().filter(player -> player.getTotal()==croupier.getTotalValue()).collect(Collectors.toList()));
                losers.addAll(playersStilIn.stream().filter(player -> player.getTotal()<croupier.getTotalValue()).collect(Collectors.toList()));
            }else{
                IoBlackJack.dealerLost();
                winners.addAll(playersStilIn);
            }
        }

        IoBlackJack.showWinners(winners);
        IoBlackJack.showEquals(equality);
        IoBlackJack.showLosers(losers);

        return winners;
    }

    private void playersPlay(){
        for (Player player: players) {
            IoBlackJack.moveToNextPlayer(player);
            boolean end = false;
            while (!end) {
                IoBlackJack.showStats(player);
                if(player.play()) {
                    croupier.giveCardTo(player);
                    if(IoBlackJack.getShow())
                        System.out.println();
                    if (checkPlayerStats(player))
                        end = true;
                }else {
                    end = true;
                    if(IoBlackJack.getShow())
                        System.out.println();
                }
            }
        }
    }


    private boolean checkPlayerStats(Player player){
        if(player.getTotal() == 21) {
            IoBlackJack.blackJack(player);
            winners.add(player);
            return true;
        }
        else if(player.getTotal() > 21 && !player.checkAs()) {
            IoBlackJack.loseMessage();
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        boolean bot = false;
        int NBBOUCLE = 100000;
        StatsCollector s = null;
        IoBlackJack.setShow(true);
        if(!bot) {
            RunBlackJack blackJack = new RunBlackJack();
            blackJack.addPlayer(new Player("NAJI", "Abdellah", "abdellah@mail.com"));
            blackJack.addPlayer(new Player("KHERRAF", "Taha", "Taha@mail.com"));
            //blackJack.addPlayer(new Player("JADAR", "Mohammed", "Mohammed@mail.com"));
            if(IoBlackJack.getShow())
                System.out.println();
            blackJack.initGame();
            if(IoBlackJack.getShow())
                System.out.println();
            blackJack.start();
        }else {
            for (int nbCard = 4; nbCard<21;nbCard++) {
                System.out.println("strategie "+nbCard+"\n");
                Player ps[] = {new Bot("NAJI", "Abdellah", "abdellah@mail.com",nbCard)
                        , new Bot("KHERRAF", "Taha", "Taha@mail.com",nbCard)
                        , new Bot("JADAR", "Mohammed", "Mohammed@mail.com",nbCard)
                        , new Bot("JADAR", "Mohammed", "Mohammed@mail.com",nbCard)
                        , new Bot("JADAR", "Mohammed", "Mohammed@mail.com",nbCard)
                        , new Bot("JADAR", "Mohammed", "Mohammed@mail.com",nbCard)};
                s = new StatsCollector(Arrays.asList(ps));

                for (int i = 0; i < NBBOUCLE; i++) {
                    RunBlackJack blackJack = new RunBlackJack();
                    for (Player p : ps) {
                        blackJack.addPlayer(p);
                    }
                    if (IoBlackJack.getShow())
                        System.out.println();
                    blackJack.initGame();
                    if (IoBlackJack.getShow())
                        System.out.println();
                    s.collect(blackJack.start());
                }
                s.Percentage(NBBOUCLE);
                System.out.println();
            }
        }
    }
}
