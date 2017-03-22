import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Genalyn Estrada on 22/03/17.
 */
public class CellTest {
    /**
     * Tests if the event array has no values.
     */
    @Test (expected=IllegalArgumentException.class)
    public void eventArrayNoValue(){
        Event [] event = new Event[1];
        Cell cell = new Cell(1, 1, event);
    }

    /**
     * Tests if the event array is null.
     */
    @Test (expected=IllegalArgumentException.class)
    public void nullArray(){
        Event [] event = new Event[0];
        Cell cell = new Cell(1, 1, event);
    }

    /**
     * Tests if a valid cell can be created.
     */
    @Test
    public void validCell(){
        Event event = new Event(1, 1, 1.00);
        Cell cell = new Cell(3, 3, new Event[]{event});
        assertTrue(true); //Would've thrown exception if failed
    }
}