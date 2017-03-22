import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Genalyn Estrada on 21/03/17.
 */

/**
 * Creates a collection of cells.
 */
public class CellCollection {
    private ArrayList<Cell> listOfCells = new ArrayList<Cell>();

    /**
     * Given a base location, find the closest n neighbours with an event.
     * @param nearestN nth neighbour
     * @param baseX base x location
     * @param baseY base y location
     * @return the first n neighbours with an event
     */

    //TODO: Check if x and y are within world bounds
    public Map<Cell, Integer> findClosest (int nearestN, int baseX, int baseY) {
        Map<Cell, Integer> manhattanDistances = new HashMap<Cell, Integer>();
        //Calculate manhattan distance of each cell in the list
        for(Cell cell : listOfCells){
            manhattanDistances.put(cell, Math.abs(cell.getX()-baseX) + Math.abs(cell.getY()-baseY));
        }

        Map<Cell, Integer> result = new LinkedHashMap<>();

        //Uses Java 8 stream to sort keys (cells) by their values (manhattan distances)
        manhattanDistances.entrySet().stream()
                .sorted(Map.Entry.<Cell, Integer>comparingByValue())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

        //Creates a map of the first n values
        Map<Cell, Integer> firstN = new LinkedHashMap<>();
        int i = 0;
        for(Map.Entry<Cell, Integer> entry : result.entrySet()){
            firstN.put(entry.getKey(), entry.getValue());
            i++;
            if (i >= nearestN) {
                break;
            }
        }
        return firstN;
    }

    /**
     * Adds a cell into the list of cells.
     * @param cell cell being added to the list
     * @return list of cells
     */
    public ArrayList<Cell> addCell (Cell cell){
        listOfCells.add(cell);
        return listOfCells;
    }

    public String toString(){
        String returnString = "";
        for(Cell cell : listOfCells){
            returnString += "\r\n" + cell.toString();
        }
        return returnString;
    }

}
