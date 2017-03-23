import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Genalyn Estrada on 22/03/17.
 */

/**
 * Creates a collection of non-empty events.
 */
public class EventCollection {
    private ArrayList<Event> listOfEvents = new ArrayList<>();

    /**
     * Generates random seed data.
     * @param eventCollection collection of events
     */
    public void generateRandomData(EventCollection eventCollection){
        EventFactory eventFactory = new EventFactory();

        int randomEventSize = ThreadLocalRandom.current().nextInt(1, 10);

        while (randomEventSize != 0) {
            int randomX = ThreadLocalRandom.current().nextInt(0, 10 + 10);
            int randomY = ThreadLocalRandom.current().nextInt(0, 10 + 10);
            Event event = eventFactory.makeEvent(randomX - 10, randomY - 10);

            int randomTicketSize = ThreadLocalRandom.current().nextInt(1, 5);

            while (randomTicketSize != 0) {
                double randomTicketPrice = ThreadLocalRandom.current().nextInt(1, 10);
                int randomTicketAvailable = ThreadLocalRandom.current().nextInt(1, 10);
                event.addTicket(randomTicketPrice, randomTicketAvailable);
                randomTicketSize--;
            }

            eventCollection.addEvent(event);
            randomEventSize--;
        }

    }

    /**
     * Finds the closest event along with the cheapest price for said event.
     * @param nearestN nearest n nieghbours in relation to base position
     * @param baseX x coordinate of base location
     * @param baseY y coordinate of base location
     * @return string that contains the eventID, cheapest event ticket and distance to event.
     */
    public String findClosestAndCheapest(int nearestN, int baseX, int baseY){
        Map<Event, Integer> firstN = findClosest(nearestN, baseX, baseY);
        Iterator<Map.Entry<Event, Integer>> it = firstN.entrySet().iterator();

        Locale locale = new Locale("en", "US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        String toReturn = "";

        //Finds cheapest ticket in event
        while (it.hasNext()) {
            Map.Entry pair = it.next();
            Event cheapestEvent = (Event) pair.getKey();
            Ticket cheapest = cheapestEvent.getCheapestTicket();
            toReturn += "Event " + String.format("%03d", cheapestEvent.getEventID())  + " - " +
                    fmt.format(cheapest.getTicketPrice()) + ", Distance " + pair.getValue() + "\r\n";
            it.remove(); // avoids a ConcurrentModificationException
        }
        return toReturn;
    }

    /**
     * Given a base location, find the closest n neighbours with an event.
     * @param nearestN nth neighbour
     * @param baseX base x location
     * @param baseY base y location
     * @return the first n neighbours with an event
     */
    public Map<Event, Integer> findClosest (int nearestN, int baseX, int baseY) throws IllegalArgumentException {
        if ((baseX >= -10 && baseX <= 10) && (baseY >= -10 && baseY <= 10)) {
            Map<Event, Integer> manhattanDistances = new HashMap<Event, Integer>();

            //Calculate manhattan distance of each cell in the list
            for(Event event : listOfEvents){
                manhattanDistances.put(event, Math.abs(event.getxLocation()-baseX) + Math.abs(event.getyLocation()-baseY));
            }

            Map<Event, Integer> result = new LinkedHashMap<>();

            //Uses Java 8 stream to sort keys (cells) by their values (manhattan distances)
            manhattanDistances.entrySet().stream()
                    .sorted(Map.Entry.<Event, Integer>comparingByValue())
                    .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

            //Creates a map of the first n values
            Map<Event, Integer> firstN = new LinkedHashMap<>();
            int i = 0;
            for(Map.Entry<Event, Integer> entry : result.entrySet()){
                firstN.put(entry.getKey(), entry.getValue());
                i++;
                if (i >= nearestN) {
                    break;
                }
            }
            return firstN;
        } else {
            throw new IllegalArgumentException("Coordinates must range from -10 to +10 (Y axis), and -10 to +10 (X axis)");
        }
    }

    /**
     * Adds new event to the list of events.
     * @param event event to be added.
     * @return list of events.
     */
    public ArrayList<Event> addEvent (Event event){
        listOfEvents.add(event);
        return listOfEvents;
    }

    public String toString(){
        String returnString = "";
        for(Event event : listOfEvents){
            returnString += "\r\n" + event.toString();
        }
        return returnString;
    }

}
