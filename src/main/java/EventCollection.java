import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Genalyn Estrada on 22/03/17.
 */
public class EventCollection {
    private ArrayList<Event> listOfEvents = new ArrayList<>();



    /**
     * Given a base location, find the closest n neighbours with an event.
     * @param nearestN nth neighbour
     * @param baseX base x location
     * @param baseY base y location
     * @return the first n neighbours with an event
     */

    //TODO: Check if x and y are within world bounds
    public Map<Event, Integer> findClosest (int nearestN, int baseX, int baseY) {
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
    }

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
