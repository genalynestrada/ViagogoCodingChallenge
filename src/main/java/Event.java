/**
 * Created by Genalyn Estrada on 21/03/17.
 */

/**
 * Creates an event object that is associated by a cell object.
 */
public class Event {
    private int ID;
    private int tickets;
    private double pricePerTicket;

    /**
     * Creates an event object.
     * @param eventID unique ID of event
     * @param ticketAvailable number of tickets available for the event
     * @param ticketPrice price of the ticket for the event
     */

    //TODO: tickets need to be an object
    //TODO: Create event test cases
    //TODO: Event unique ID
    public Event (int eventID, int ticketAvailable, double ticketPrice){
        ID = eventID;
        tickets = ticketAvailable;
        pricePerTicket = ticketPrice;
    }

    public int getEventID(){return ID;}
    public int getTicketAvailable(){return tickets;}
    public double getTicketPrice(){return pricePerTicket;}

    public String toString(){
        return ("ID: " + ID + " Tickets: " + tickets + " Price: " + pricePerTicket);
    }

}
