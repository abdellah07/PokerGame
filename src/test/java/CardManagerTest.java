import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardManagerTest {
    CardManager cardManager;


    @Before
    public void setup(){
        cardManager = new CardManagerImpl();
    }

    @Test
    public void testDeck(){
        assertEquals(52,cardManager.numberOfCardsLeft());

        assertTrue(AllowedValues.isAllowedValue(cardManager.getCard().getValue().getValue()));

        System.out.println(cardManager);
    }
}
