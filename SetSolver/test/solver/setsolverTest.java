package solver;

import org.junit.Before;
import org.junit.Test;
import solver.Card.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class setsolverTest {
    setsolver solver;

    @Before
    public void setup(){
       solver = new setsolver();
    }

    @Test
    public void matchIfColorsAreTheSame(){
        Card one = new Card(Colors.GREEN, Symbols.DIAMOND, Numbers.ONE);
        Card two = new Card(Colors.GREEN, Symbols.DIAMOND, Numbers.TWO);
        Card three = new Card(Colors.GREEN, Symbols.DIAMOND, Numbers.THREE);
        assertTrue(solver.matchInColor(one, two, three));
    }

    @Test
    public void matchIfColorsAreNotTheSame(){
        Card one = new Card(Colors.GREEN, Symbols.DIAMOND, Numbers.ONE);
        Card two = new Card(Colors.RED, Symbols.DIAMOND, Numbers.TWO);
        Card three = new Card(Colors.PURPLE, Symbols.DIAMOND, Numbers.THREE);
        assertTrue(solver.matchInColor(one, two, three));
    }

    @Test
    public void noMatchIfTwoColorsAreTheSame(){
        Card one = new Card(Colors.GREEN, Symbols.DIAMOND, Numbers.ONE);
        Card two = new Card(Colors.GREEN, Symbols.DIAMOND, Numbers.TWO);
        Card three = new Card(Colors.PURPLE, Symbols.DIAMOND, Numbers.THREE);
        assertFalse(solver.matchInColor(one, two, three));
    }

    @Test
    public void checkAMatch(){
        Card one = new Card(Colors.GREEN, Symbols.DIAMOND, Numbers.ONE);
        Card two = new Card(Colors.RED, Symbols.DIAMOND, Numbers.TWO);
        Card three = new Card(Colors.PURPLE, Symbols.DIAMOND, Numbers.THREE);
        assertTrue(solver.checkMatches(one, two, three));
    }

    @Test
    public void checkNoMatch(){
        Card one = new Card(Colors.GREEN, Symbols.DIAMOND, Numbers.ONE);
        Card two = new Card(Colors.RED, Symbols.DIAMOND, Numbers.TWO);
        Card three = new Card(Colors.PURPLE, Symbols.DIAMOND, Numbers.TWO);
        assertFalse(solver.checkMatches(one, two, three));
    }

    @Test
    public void testCardsInList(){

    }
}
