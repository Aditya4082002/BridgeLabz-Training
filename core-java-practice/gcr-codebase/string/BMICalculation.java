//program for BMI calculations of a team of 10 memebers
import java.util.Scanner;

class BMICalculation {
    public static void main(String[] args) {
        // create scanner object
        Scanner input = new Scanner(System.in);

        int persons = 10;

        // 2D array to store weight and height (kg, cm)
        double[][] heightWeight = new double[persons][2];

        // Take user input
        for (int i = 0; i < persons; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter weight (in kg): ");
            heightWeight[i][0] = input.nextDouble();

            System.out.print("Enter height (in cm): ");
            heightWeight[i][1] = input.nextDouble();
        }

        // Compute BMI details
        String[][] bmiData = generateBMIReport(heightWeight);

        // Display result
        displayBMIReport(bmiData);

        // close scanner stream
        input.close();
    }

    // Method to compute BMI and status for one person
    public static String[] calculateBMIAndStatus(double weight, double heightCm) {

        double heightMeter = heightCm / 100.0;
        double bmi = weight / (heightMeter * heightMeter);

        // Round BMI to 2 decimal places
        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 40) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {
                String.valueOf(heightCm),
                String.valueOf(weight),
                String.valueOf(bmi),
                status
        };
    }

    // Method to generate BMI report for all persons
    public static String[][] generateBMIReport(double[][] data) {

        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            String[] bmiResult = calculateBMIAndStatus(data[i][0], data[i][1]);

            result[i][0] = bmiResult[0]; // Height
            result[i][1] = bmiResult[1]; // Weight
            result[i][2] = bmiResult[2]; // BMI
            result[i][3] = bmiResult[3]; // Status
        }

        return result;
    }

    // Method to display BMI report in tabular format
    public static void displayBMIReport(String[][] data) {

        System.out.println("-------------------------------------------------------");
        System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t\t" + data[i][3]);
        }

        System.out.println("-------------------------------------------------------");
    }
}