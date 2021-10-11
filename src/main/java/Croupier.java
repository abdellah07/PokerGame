public class Croupier {
    private CardManager cardManager;

    public Croupier(){
        cardManager = new CardManagerImpl();
    }

    public void giveCardTo(Player player){
        player.addCardToHand(cardManager.getCard());
    }




}
