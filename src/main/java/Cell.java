/**
 * Created by Genalyn Estrada on 21/03/17.
 */

/**
 * Creates a cell object that contains an event.
 */
public class Cell {
    private int x;
    private int y;
    private Event[] events;

    /**
     * Creates a cell object.
     * @param xLocation x position of the cell
     * @param yLocation y position of the cell
     * @param eventsAtLocation list of events happening within cell
     * @throws IllegalArgumentException if event array values is null or if it is empty
     */
    //TODO: Check if x and y values are within the world bounds
    public Cell(int xLocation, int yLocation, Event[] eventsAtLocation) throws IllegalArgumentException{
        if (eventsAtLocation.length <= 0) {
            throw new IllegalArgumentException("Event array contains no values.");
        } else {
            for(Event event : eventsAtLocation){
                if (event == null) {
                    throw new IllegalArgumentException("Event array contains null values.");
                }
            }
        }

        x = xLocation;
        y = yLocation;
        events = eventsAtLocation;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public Event[] getEvents(){return events;}

    public String toString(){
        String returnString = ("X: " + x + " Y: " + y);
        for(Event event : events){
            returnString += "\r\n"+ event.toString();
        }
        return returnString;
    }
}
