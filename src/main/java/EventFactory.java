/**
 * Created by Genalyn Estrada on 22/03/17.
 */
public class EventFactory {
    private int eventID = 0;

    public Event makeEvent(int xLocation, int yLocation){
        Event event = new Event(eventID, xLocation, yLocation);
        eventID++;
        return event;
    }
}
