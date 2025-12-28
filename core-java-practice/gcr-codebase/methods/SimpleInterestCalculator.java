//Program to input the Principal, Rate, and Time values and calculate Simple Interest
import java.util.Scanner;

class SimpleInterestCalculator {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter Principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = input.nextDouble();

        // Calculate simple interest
        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        // Display result
        System.out.println( "The Simple Interest is " + simpleInterest + "for Principal " + principal +
            ", Rate of Interest " + rate + " and Time " + time);
            
        //close scanner stream
        input.close();
    }

    // Method to calculate Simple Interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}