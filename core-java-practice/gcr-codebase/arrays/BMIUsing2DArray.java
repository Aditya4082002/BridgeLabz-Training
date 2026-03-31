//program to find BMI of multiple persons using 2D array.

//import Scanner class to take input from user
import java.util.Scanner;

class BMIUsing2DArray {
    public static void main(String[] args) {
        //create a Scanner object
        Scanner input = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        // Create arrays to store data
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input height and weight with validation
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));

            // Height input (must be positive)
            do {
                System.out.print("Enter height (in meters): ");
                personData[i][0] = input.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Height must be positive. Please re-enter.");
                }
            } while (personData[i][0] <= 0);

            // Weight input (must be positive)
            do {
                System.out.print("Enter weight (in kg): ");
                personData[i][1] = input.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Weight must be positive. Please re-enter.");
                }
            } while (personData[i][1] <= 0);
        }

        // Calculate BMI and determine status
        for (int i = 0; i < number; i++) {

            double height = personData[i][0];
            double weight = personData[i][1];

            // BMI calculation
            personData[i][2] = weight / (height * height);

            // Weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\n----- BMI REPORT -----");
        System.out.printf("%-10s %-10s %-10s %-15s%n",
                          "Height", "Weight", "BMI", "Status");

        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f      %.2f      %.2f      %-15s%n",
                              personData[i][0],
                              personData[i][1],
                              personData[i][2],
                              weightStatus[i]);
        }

        input.close();
    }
}
