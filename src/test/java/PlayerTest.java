import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    Player player;


    @Before
    public void setup(){
        player = new Player("","","");
    }

    @Test
    public void testDeck(){
        System.out.println(player);
        System.out.println(player.getTokens());
    }
}
