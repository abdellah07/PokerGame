package casino.blackjack;

import casino.cards.CardManagerImpl;

public class CardManagerBJ extends CardManagerImpl {
    CardManagerBJ(){
        for (int i = 0;i<8;i++){
            generateDeck();
        }
    }
}
