import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {

        //create a scanner object
        Scanner input = new Scanner(System.in);

        double[][] personData = new double[10][3];

        // Take input for weight and height
        for (int i = 0; i < personData.length; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            personData[i][0] = input.nextDouble();

            System.out.print("Enter height (cm): ");
            personData[i][1] = input.nextDouble();
        }

        // Calculate BMI
        calculateBMI(personData);

        // Find BMI status
        String[] bmiStatus = findBMIStatus(personData);

        // Display result
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < personData.length; i++) {
            System.out.println(
                personData[i][1] + "\t\t" +
                personData[i][0] + "\t\t" +
                personData[i][2] + "\t\t" +
                bmiStatus[i]
            );
        }

        //close scanner stream
        input.close();
    }

    // Method to calculate BMI and populate array
    static void calculateBMI(double[][] data) {

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];

            // Convert cm to meters
            double heightMeter = heightCm / 100.0;

            double bmi = weight / (heightMeter * heightMeter);

            // Round BMI to 2 decimal places
            bmi = Math.round(bmi * 100.0) / 100.0;

            data[i][2] = bmi;
        }
    }

    // Method to determine BMI Status
    static String[] findBMIStatus(double[][] data) {

        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {

            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 40) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }
}
