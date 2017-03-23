import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Genalyn Estrada on 23/03/17.
 */
public class ClosestEventsDemo {

    public static void main(String[] args) {
        EventCollection eventCollection = new EventCollection();
        eventCollection.generateRandomData(eventCollection);
        Scanner reader = new Scanner(System.in);

        try {
            System.out.print("Please input X coordinate: ");
            int xValue = reader.nextInt();

            System.out.print("Please input Y coordinate: ");
            int yValue = reader.nextInt();

            if ((xValue >= -10 && xValue <= 10) && (yValue >= -10 && yValue <=10)) {
                System.out.println("===========================");
                System.out.println("Random events: \r\n" + eventCollection.toString());
                System.out.println("\r\nClosest events to (" + xValue + "," + yValue + "):");
                System.out.println(eventCollection.findClosestAndCheapest(5, xValue, yValue));
            } else {
                throw new IllegalStateException("Coordinates must range from -10 to +10 (Y axis), and -10 to +10 (X axis).");
            }
        } catch (InputMismatchException e) {
            System.out.println("Coordinates must be a number.");
        }
    }

}
