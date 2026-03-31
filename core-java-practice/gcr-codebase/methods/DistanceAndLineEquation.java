import java.util.Scanner;

public class DistanceAndLineEquation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input coordinates of first point
        System.out.print("Enter x1: ");
        double x1 = input.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = input.nextDouble();

        // Input coordinates of second point
        System.out.print("Enter x2: ");
        double x2 = input.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = input.nextDouble();

        // Calculate Euclidean distance
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);

        // Calculate slope and y-intercept
        double[] lineEquation = findLineEquation(x1, y1, x2, y2);

        // Display results
        System.out.println("\nEuclidean Distance between points: " + distance);
        System.out.println("Equation of the line: y = " 
                + lineEquation[0] + "x + " + lineEquation[1]);

        input.close();
    }

    // Method to calculate Euclidean distance between two points
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {

        return Math.sqrt( Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to find slope (m) and y-intercept (b)
    // Returns an array where index 0 = slope, index 1 = y-intercept
    public static double[] findLineEquation( double x1, double y1, double x2, double y2) {

        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - (slope * x1);

        return new double[]{slope, yIntercept};
    }
}