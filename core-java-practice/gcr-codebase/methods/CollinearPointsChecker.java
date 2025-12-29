import java.util.Scanner;

public class CollinearPointsChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input coordinates of three points
        System.out.println("Enter coordinates of Point A:");
        int x1 = input.nextInt();
        int y1 = input.nextInt();

        System.out.println("Enter coordinates of Point B:");
        int x2 = input.nextInt();
        int y2 = input.nextInt();

        System.out.println("Enter coordinates of Point C:");
        int x3 = input.nextInt();
        int y3 = input.nextInt();

        // Check collinearity using slope method
        boolean slopeResult = areCollinearUsingSlope(x1, y1, x2, y2, x3, y3);

        // Check collinearity using area method
        boolean areaResult = areCollinearUsingArea(x1, y1, x2, y2, x3, y3);

        // Display results
        System.out.println("\nUsing Slope Formula:");
        System.out.println(slopeResult ? "Points are collinear" : "Points are not collinear");

        System.out.println("\nUsing Area of Triangle Formula:");
        System.out.println(areaResult ? "Points are collinear" : "Points are not collinear");

        input.close();
    }

    // Method to check collinearity using slope formula
    public static boolean areCollinearUsingSlope( int x1, int y1, int x2, int y2, int x3, int y3) {

        // Avoid division by zero by cross-multiplication
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1) || (y3 - y2) * (x3 - x1) == (y3 - y1) * (x3-x2);
    }

    // Method to check collinearity using area of triangle formula
    public static boolean areCollinearUsingArea( int x1, int y1, int x2, int y2, int x3, int y3) {

        double area = 0.5 * ( x1 * (y2 - y3) + x2 * (y3 - y1) +x3 * (y1 - y2) );

        return area == 0;
    }
}