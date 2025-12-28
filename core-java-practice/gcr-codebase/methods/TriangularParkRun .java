import java.util.Scanner;

class TriangularParkRun {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input for triangle sides
        System.out.print("Enter side 1 (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 (in meters): ");
        double side3 = input.nextDouble();

        // Calculate number of rounds
        double rounds = calculateRounds(side1, side2, side3);

        // Display result
        System.out.println( "To complete a 5 km run, the athlete must complete " + rounds + " rounds.");

        //close scanner stream
        input.close();
    }

    // Method to compute number of rounds
    static double calculateRounds(double side1, double side2, double side3) {

        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000; // meters (5 km)

        return totalDistance / perimeter;
    }
}