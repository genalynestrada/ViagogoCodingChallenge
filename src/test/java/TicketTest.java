import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Genalyn Estrada on 23/03/17.
 */
public class TicketTest {

    @Test
    public void validTicket(){
        Ticket ticket = new Ticket(2, 2);
        assertEquals(ticket.toString(), "TicketPrice: 2.0 TicketsAvailable: 2");
    }

    @Test (expected=IllegalArgumentException.class)
    public void invalidTicket(){
        Ticket ticket = new Ticket(-3, 2);
    }

}