/**
 * Created by Genalyn Estrada on 22/03/17.
 */

/**
 * Creates an event object which ensures the the ID is unique.
 */
public class EventFactory {
    private int eventID = 1;

    /**
     * Creates an event object whilst keeping evenID unique.
     * @param xLocation x coordinate of event.
     * @param yLocation y coordinate of event.
     * @return event created.
     */
    public Event makeEvent(int xLocation, int yLocation){
        Event event = new Event(eventID, xLocation, yLocation);
        eventID++;
        return event;
    }
}
