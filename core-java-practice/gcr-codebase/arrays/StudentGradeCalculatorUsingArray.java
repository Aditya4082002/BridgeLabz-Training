//program to calculate student grades using array 

import java.util.Scanner;
class StudentGradeCalculatorUsingArray {
    public static void main(String[] args) {
        //create object of Scanner
        Scanner input = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter number of students: ");
        int number = input.nextInt();

        // Create arrays to store data
        int[] physics = new int[number];
        int[] chemistry = new int[number];
        int[] maths = new int[number];
        double[] percentage = new double[number];
        char[] grade = new char[number];

        // Take input for marks with validation
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1));

            System.out.print("Enter Physics marks: ");
            physics[i] = input.nextInt();

            System.out.print("Enter Chemistry marks: ");
            chemistry[i] = input.nextInt();

            System.out.print("Enter Maths marks: ");
            maths[i] = input.nextInt();

            // Check for negative marks
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("Marks must be positive. Please re-enter all marks.");
                i--; // decrement index
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < number; i++) {
            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            }
            else if (percentage[i] >= 70){
                grade[i] = 'B';
            } 
            else if (percentage[i] >= 60){
                grade[i] = 'C';
            } 
            else if (percentage[i] >= 50){
                grade[i] = 'D';
            } 
            else if (percentage[i] >= 40){
                grade[i] = 'E';
            } 
            else {
                grade[i] = 'R';
            }
        }

        // Display result
        System.out.println("STUDENT REPORT");
        System.out.printf("%-10s %-10s %-10s %-12s %-10s%n", "Physics", "Chemistry", "Maths", "Percentage", "Grade");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10d %-10d %-10d %-12.2f %-10c%n", physics[i], chemistry[i], maths[i], percentage[i], grade[i]);
        
        }

        //Closing the Scanner Stream
        input.close();
    }
}

