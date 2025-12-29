import java.util.Scanner;

public class BusRouteDistanceTracker {

    public static void main(String[] args) {

        //Create scanner object for user input
        Scanner input = new Scanner(System.in);

        // Variable to store total distance travelled
        double totalDistanceInKm = 0.0;

        // Variable to store passenger's choice
        String passengerChoice = "no";

        System.out.println("Bus Route Distance Tracker Started");

        //assume distance between each stop is 5km
        double distanceBetweenStops = 5;

        // Loop continues until passenger decides to get off
        while (!passengerChoice.equalsIgnoreCase("yes")) {

            // Add current stop distance to total distance
            totalDistanceInKm += distanceBetweenStops;

            // Display total distance travelled so far
            System.out.println("Total distance so far: " + totalDistanceInKm + " km");

            // Ask passenger whether they want to get off
            System.out.print("Do you want to get off at this stop? (yes/no): ");
            passengerChoice = input.next();
        }

        // Final output
        System.out.println("\nPassenger got off the bus.");
        System.out.println("Total distance traveled: " + totalDistanceInKm + " km");

        // Close the Scanner object
        input.close();
    }
}
