/**
 * Created by Genalyn Estrada on 22/03/17.
 */
public class Ticket {
    private double ticketPrice;
    private int ticketsAvailable;

    public Ticket(double ticketPrice, int ticketsAvailable){
        this.ticketPrice = ticketPrice;
        this.ticketsAvailable = ticketsAvailable;
    }

    public double getTicketPrice() {return ticketPrice;}
    public int getTicketsAvailable() {return ticketsAvailable;}
}
