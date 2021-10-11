import Exceptions.NotAllowedValueException;
import org.junit.Test;
import static org.junit.Assert.assertThrows;

public class CardTest {
    @Test
    public void testCard(){
        assertThrows(NotAllowedValueException.class,()->{new Card(CardType.CARREAU,"Z");});
        assertThrows(NotAllowedValueException.class,()->{new Card(CardType.CARREAU,"h");});
        assertThrows(NotAllowedValueException.class,()->{new Card(CardType.CARREAU,"a");});
        assertThrows(NotAllowedValueException.class,()->{new Card(CardType.CARREAU,"v");});
        assertThrows(NotAllowedValueException.class,()->{new Card(CardType.CARREAU,"d");});
        assertThrows(NotAllowedValueException.class,()->{new Card(CardType.CARREAU,"r");});


    }
}
