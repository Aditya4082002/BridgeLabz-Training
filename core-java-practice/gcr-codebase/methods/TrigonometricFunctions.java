//Program to calculate various trigonometric functions using Math class given an angle in degrees
import java.util.Scanner;

class TrigonometricFunctions {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter angle in degrees: ");
        double angle = input.nextDouble();

        // Calculate trigonometric values
        double[] result = calculateTrigonometricFunctions(angle);

        // Display results
        System.out.println("Sine value      : " + result[0]);
        System.out.println("Cosine value    : " + result[1]);
        System.out.println("Tangent value   : " + result[2]);

        //close scanner stream
        input.close();
    }

    // Method to calculate trigonometric functions
    public static double[] calculateTrigonometricFunctions(double angle) {

        // Convert degrees to radians
        double radians = Math.toRadians(angle);

        double sinValue = Math.sin(radians);
        double cosValue = Math.cos(radians);
        double tanValue = Math.tan(radians);

        return new double[]{sinValue, cosValue, tanValue};
    }
}