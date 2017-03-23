/**
 * Created by Genalyn Estrada on 22/03/17.
 */

/**
 * Creates a Ticket object.
 */
public class Ticket {
    private double ticketPrice;
    private int ticketsAvailable;

    /**
     * Creates a Ticket object.
     * @param ticketPrice price of the ticket.
     * @param ticketsAvailable number of available tickets.
     * @throws IllegalArgumentException
     */
    public Ticket(double ticketPrice, int ticketsAvailable) throws IllegalArgumentException{
        if (ticketPrice > 0) {
            this.ticketPrice = ticketPrice;
            this.ticketsAvailable = ticketsAvailable;
        } else {
            throw new IllegalArgumentException("Ticket price must be a non-negative value.");
        }

    }

    public double getTicketPrice() {return ticketPrice;}
    public int getTicketsAvailable() {return ticketsAvailable;}
    public String toString(){return "TicketPrice: " + ticketPrice + " TicketsAvailable: " + ticketsAvailable;}
}
