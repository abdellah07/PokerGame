package casino.blackjack;

import casino.player.Croupier;
import casino.player.Hand;
import casino.player.Player;

import java.io.PrintStream;
import java.util.List;

import static casino.util.ConsoleColor.*;
import static casino.util.ConsoleColor.BLUE;

public class IoBlackJack {
    private static PrintStream output = System.out;
    private static boolean show = false;

    public static boolean getShow(){
        return show;
    }

    public static void setShow(boolean show) {
        IoBlackJack.show = show;
    }

    public static void startMenu(){
        if (show) {
            output.println(CYAN + "##### Welcome To The New Casino ##### \n".toUpperCase() + RESET);
            output.println(CYAN + "  ########### Black Jack ##########   \n".toUpperCase() + RESET);
        }
    }

    public static void playerJoined(Player player){
        if (show)
            output.println(GREEN+"## "+BLUE+player.getName()+" Joined the Game".toUpperCase()+RESET);
    }

    public static void separator(){
        if(show)
            output.println("###############################################################################################");
    }

    public static void showStats(Player player){
        if (show){
            System.out.println(GREEN+"## Player ".toUpperCase()+BLUE+player.getName()+GREEN+" have ".toUpperCase()+BLUE+player.showCards() + GREEN+". Total Value is ".toUpperCase()+BLUE+player.getTotal()+RESET);
        }
    }

    public static void moveToNextPlayer(Player player){
        if (show)
            System.out.println(YELLOW+"############################# MOVE TO PLAYER "+player.getName()+" ############################# \n"+RESET);
    }

    public static void showStats(CroupierBlackJack croupier){
        if (show){
            System.out.println(GREEN +"##"+BLUE+ "Dealer "+croupier.getStats());
        }
    }

    public static void dealerLost(){
        if (show){
            System.out.println(GREEN + "## " + RED + " \t Dealer lost".toUpperCase() + RESET);
        }
    }

    public static void blackJack(Player player){
        if (show)
            System.out.println(GREEN + "## " + PURPLE + " $$ BINGO BLACK JACK $$ ".toUpperCase() + BLUE + player.getName() + PURPLE + " WON ".toUpperCase() + RESET+"\n");
    }

    public static void loseMessage(){
        if (show)
            System.out.println(GREEN + "## " + RED + " YOU LOST " + RESET+"\n");
    }

    public static void everyOneLost(){
        if (show)
            System.out.println(GREEN + "## " + RED + " \t everyone lost".toUpperCase() + RESET);
    }

    public static void showWinners(List<Player> winners){
        if (show){
            if(!winners.isEmpty()) {
                System.out.println("\n" + GREEN + "## " + PURPLE + " \t Winners".toUpperCase()+GREEN+" are :".toUpperCase() + RESET);
                for (Player winner : winners)
                    System.out.println(GREEN + "## \t" + PURPLE + "\t\t\t" + winner.getName() + RESET);
            }
        }
    }
    public static void showEquals(List<Player> equality){
        if (show){
            if(!equality.isEmpty()) {
                System.out.println("\n" + GREEN + "## " + WHITE + " \t Equality :".toUpperCase()+GREEN+" are :".toUpperCase() + RESET);
                for (Player equal : equality)
                    System.out.println(GREEN + "## \t" + BLUE + "\t\t\t" + equal.getName() + RESET);
            }
        }
    }
    public static void showLosers(List<Player> losers){
        if (show){
            if(!losers.isEmpty()) {
                System.out.println("\n" + GREEN + "## " + RED + " \t Losers :".toUpperCase()+GREEN+" are :".toUpperCase() + RESET);
                for (Player loser : losers)
                    System.out.println(GREEN + "## \t" + RED + "\t\t\t" + loser.getName() + RESET);
            }
        }
    }

    //Partie croupier

    public static void showOneCard(Hand hand){
        if(IoBlackJack.getShow())
            System.out.println(GREEN+"## The dealer have ".toUpperCase()+BLUE+hand.getCards().get(0)+GREEN+" and a hidden card.".toUpperCase()+RESET);
    }
}
