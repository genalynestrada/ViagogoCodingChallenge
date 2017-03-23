import org.junit.Before;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Genalyn Estrada on 22/03/17.
 */
public class EventCollectionTest {
    private EventCollection eventCollection;


    @Before
    public void setUp() {
        eventCollection = new EventCollection();
    }

    @Test (expected=IllegalArgumentException.class)
    public void invalidFindClosest() {
        eventCollection.findClosest(2, 2, -20);
    }

    @Test
    public void generateTestEvents() {
        EventFactory eventFactory = new EventFactory();

        Event event = eventFactory.makeEvent(2, 4);
        Event event2 = eventFactory.makeEvent(4, 6);
        Event event3 = eventFactory.makeEvent(0, 9);
        Event event4 = eventFactory.makeEvent(9, 6);
        Event event5 = eventFactory.makeEvent(6, 0);

        event.addTicket(2.00, 5);
        event.addTicket(5.00, 5);

        event2.addTicket(1.00, 10);
        event2.addTicket(2.00, 10);

        event3.addTicket(1.00, 10);
        event3.addTicket(2.00, 10);

        event4.addTicket(1.00, 10);
        event4.addTicket(2.00, 10);

        event5.addTicket(1.00, 10);
        event5.addTicket(2.00, 10);

        eventCollection.addEvent(event);
        eventCollection.addEvent(event2);
        eventCollection.addEvent(event3);
        eventCollection.addEvent(event4);
        eventCollection.addEvent(event5);




//        System.out.println("Event Collection: ");
//        System.out.println(eventCollection.toString());
//        System.out.println("=================================");
//        System.out.println(eventCollection.findClosestAndCheapest(2, 4, 0));

        assertEquals(eventCollection.findClosestAndCheapest(2, 4, 0), "Event 005 - $1.00, " +
                "Distance 2\r\nEvent 001 - $2.00, Distance 6\r\n");
    }

}