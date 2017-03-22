/**
 * Created by Genalyn Estrada on 21/03/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Creates an event object that is associated by a cell object.
 */
public class Event {
    private List<Ticket> listOfTickets = new ArrayList<Ticket>();
    private int eventID;
    private int xLocation;
    private int yLocation;

    /**
     * Creates an event object.
     *
     */
    //TODO: Create event test cases
    //TODO: Test for invalid input
    public Event (int eventID, int xLocation, int yLocation){
        this.eventID = eventID;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void addTicket(double ticketPrice, int ticketsAvailable){
        Ticket ticket = new Ticket(ticketPrice, ticketsAvailable);
        listOfTickets.add(ticket);
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
