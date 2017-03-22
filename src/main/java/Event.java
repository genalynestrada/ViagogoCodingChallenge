/**
 * Created by Genalyn Estrada on 21/03/17.
 */

/**
 * Creates an event object that is associated by a cell object.
 */
public class Event {
    private Ticket[] listOfTickets;

    /**
     * Creates an event object.
     *
     */
    //TODO: tickets need to be an object
    //TODO: Create event test cases
    //TODO: Event unique ID
    //TODO: Test for invalid input
    public Event (Ticket[] listOfTickets){
        this.listOfTickets = listOfTickets;
    }

    //public String toString(){
    //    return (" Tickets: " + tickets + " Price: " + pricePerTicket);
    //}

}
