import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by Genalyn Estrada on 21/03/17.
 */

public class CellCollectionTest {
    private CellCollection cellCollection;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        cellCollection = new CellCollection();
    }

//    @Test
//    public void addCell() throws Exception {
//        Event event = new Event(1, 10, 5.00);
//        Cell cell = new Cell(0, 0, new Event[]{event});
//        ArrayList<Cell> cells = cellCollection.addCell(cell);
//        assertNotNull(cells);
//        System.out.println(cellCollection.toString());
//    }

    @Test
    public void generateTestCells() {
        Ticket ticket = new Ticket(1.00, 5);
        Ticket ticket2 = new Ticket(2.00, 5);

        Event event = new Event(new Ticket[]{ticket, ticket2});
        Event event2 = new Event(new Ticket[]{ticket, ticket2});
//        Event event2 = new Event(2, 10, 10.00);
//        Event event3 = new Event(3, 10, 10.00);
//        Event event4 = new Event(4, 10, 10.00);
//        Event event5 = new Event(5, 10, 10.00);

        Cell cell = new Cell(2, 4, new Event[]{event});
        Cell cell2 = new Cell(4, 6, new Event[]{event2});
//        Cell cell3 = new Cell(7, 9, new Event[]{event3});
//        Cell cell4 = new Cell(9, 3, new Event[]{event4});
//        Cell cell5 = new Cell(9, 15, new Event[]{event5});

        cellCollection.addCell(cell);
        cellCollection.addCell(cell2);
//        cellCollection.addCell(cell3);
//        cellCollection.addCell(cell4);
//        cellCollection.addCell(cell5);

        Map<Cell, Integer> firstN = cellCollection.findClosest(4, 0, 0);
        Iterator<Map.Entry<Cell, Integer>> it = firstN.entrySet().iterator();
        Map.Entry<Cell, Integer> valToCheck = it.next();

        assertEquals(valToCheck.getKey(), cell);

        valToCheck = it.next();
        assertEquals(valToCheck.getKey(), cell2);

        System.out.print(firstN);
//
//        valToCheck = it.next();
//        assertEquals(valToCheck.getKey(), cell4);
//
//        valToCheck = it.next();
//        assertEquals(valToCheck.getKey(), cell3);
    }



}