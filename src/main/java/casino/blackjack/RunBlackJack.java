package casino.blackjack;

import casino.player.Croupier;
import casino.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static casino.util.ConsoleColor.*;

public class RunBlackJack {
    private List<Player> players;
    CroupierBlackJack croupier;

    void initCroupier(){
        croupier.takeCards();
    }

    RunBlackJack(){
        players = new ArrayList<>();
        croupier = new CroupierBlackJack();
        System.out.println(CYAN+"##### Welcome To The New Casino ##### \n".toUpperCase()+RESET);
        System.out.println(CYAN+"  ########### Black Jack ##########   \n".toUpperCase()+RESET);
    }

    void addPlayer(Player player){
        System.out.println(GREEN+"## "+BLUE+player.getName()+" Joined the Game".toUpperCase()+RESET);
        players.add(player);
    }

    public void initGame(){
        for (Player player: players) {
            croupier.giveCardTo(player,2);
            showPlayerStats(player);
        }
        croupier.takeCards();
    }

    public void showPlayerStats(Player player){
        System.out.println(GREEN+"## Player ".toUpperCase()+BLUE+player.getName()+GREEN+" have ".toUpperCase()+BLUE+player.showCards() + GREEN+". Total Value is ".toUpperCase()+BLUE+player.getTotal()+RESET);
    }

    public void start(){
        for (Player player: players) {
            boolean end = false;
            while (!end) {
                showPlayerStats(player);
                if(askPlayerToPull(player)) {
                    croupier.giveCardTo(player);
                    if (checkPlayerStats(player).isPresent())
                        end = true;
                }else{
                    end = true;
                }
            }
        }
    }

    private Optional<Boolean> checkPlayerStats(Player player){
        showPlayerStats(player);
        if(player.getTotal() == 21) {
            System.out.println(GREEN + "## " + PURPLE + " $$ BINGO BLACK JACK $$ ".toUpperCase() + BLUE + player.getName() + PURPLE + " WON ".toUpperCase() + RESET);
            return Optional.of(true);
        }
        else if(player.getTotal() > 21) {
            System.out.println(GREEN + "## " + RED + " YOU LOST " + RESET);
            return Optional.of(false);
        }
        return Optional.empty();

    }
    private boolean askPlayerToPull(Player player){
        System.out.println(GREEN+"## Player ".toUpperCase()+BLUE+player.getName()+GREEN+" Do you want to pull a card. (y/n)".toUpperCase()+RESET);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(s.toUpperCase().equals("Y"))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        RunBlackJack blackJack = new RunBlackJack();
        blackJack.addPlayer(new Player("NAJI","Abdellah","abdellah@mail.com"));
        blackJack.addPlayer(new Player("KHERRAF","Taha","Taha@mail.com"));
        blackJack.addPlayer(new Player("JADAR","Mohammed","Mohammed@mail.com"));
        System.out.println();
        blackJack.initGame();
        blackJack.start();

    }
}
