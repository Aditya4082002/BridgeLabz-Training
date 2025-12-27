//program to find BMI of multiple persons using array.

//import Scanner class to take input from user
import java.util.Scanner;

class BMIUsingArray {
    public static void main(String[] args) {
        //create a Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        // Create arrays to store data
        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        // Take input for height and weight
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.print("Enter height (in meters): ");
            height[i] = input.nextDouble();

            System.out.print("Enter weight (in kg): ");
            weight[i] = input.nextDouble();
        }

        // Calculate BMI and determine status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal";
            } else if (bmi[i] < 40) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display results
        System.out.println("BMI REPORT");
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height", "Weight", "BMI", "Status");

        for (int i = 0; i < n; i++) {
            System.out.printf(
                "%.2f      %.2f      %.2f      %-15s%n",
                height[i], weight[i], bmi[i], status[i]
            );
        }

        input.close();
    }
}
