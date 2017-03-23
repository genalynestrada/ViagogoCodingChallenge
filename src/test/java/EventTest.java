import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Genalyn Estrada on 22/03/17.
 */
public class EventTest {
    @Test
    public void validCoordinates(){
        Event event = new Event(1, 1,1);
        assertEquals(event.toString(), "EventID: 1 Xlocation: 1 Ylocation: 1\r\nListoftickets: \r\n===========================");
    }

    @Test (expected=IllegalArgumentException.class)
    public void invalidCoordinates(){
        Event event = new Event(1, -11, -11);
    }

}