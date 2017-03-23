/**
 * Created by Genalyn Estrada on 21/03/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Creates an event object that can create tickets.
 */
public class Event {
    private List<Ticket> listOfTickets = new ArrayList<Ticket>();
    private int eventID;
    private int xLocation;
    private int yLocation;

    /**
     * Creates an event object.
     * @param eventID uniqueID of event given by EventFactory
     * @param xLocation x coordinates of event
     * @param yLocation y coordinates of event
     * @throws IllegalArgumentException
     */
    public Event (int eventID, int xLocation, int yLocation) throws IllegalArgumentException{
        if ((xLocation >= -10 && xLocation <= 10) && (yLocation >= -10 && yLocation <= 10)) {
            this.eventID = eventID;
            this.xLocation = xLocation;
            this.yLocation = yLocation;
        } else {
            throw new IllegalArgumentException("Coordinates must range from -10 to +10 (Y axis), and -10 to +10 (X axis)");
        }
    }

    /**
     * Creates a Ticket object for an event.
     * @param ticketPrice price of the ticket.
     * @param ticketsAvailable number of available tickets.
     */
    public void addTicket(double ticketPrice, int ticketsAvailable){
        Ticket ticket = new Ticket(ticketPrice, ticketsAvailable);
        listOfTickets.add(ticket);
    }

    /**
     * Returns the cheapest ticket for an event.
     * @return cheapest ticket for an event.
     */
    public Ticket getCheapestTicket(){
        Ticket cheapest = listOfTickets.get(0);
        for(Ticket ticket :  listOfTickets){
            if (ticket.getTicketPrice() < cheapest.getTicketPrice()) {
                cheapest = ticket;
            }
        }
        return cheapest;
    }


    public int getEventID(){return eventID;}
    public int getxLocation(){return xLocation;}
    public int getyLocation(){return yLocation;}
    public List<Ticket> getListOfTickets(){return listOfTickets;}

    public String toString(){
        String toReturn = "EventID: " + eventID + " Xlocation: " + xLocation + " Ylocation: " + yLocation + "\r\nListoftickets: ";

        for(Ticket ticket : listOfTickets){
            toReturn += "\r\n" + ticket.toString();
        }
        toReturn += "\r\n===========================";
        return toReturn;
    }

}
