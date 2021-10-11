import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardManagerTest {
    CardManager cardManager;

    @Before
    public void setup(){
        cardManager = new CardManager();
    }

    @Test
    public void testDeck(){
        assertEquals(52,cardManager.numberOfCards());
        cardManager.shuffleDeck();
        System.out.println(cardManager);
    }
}
