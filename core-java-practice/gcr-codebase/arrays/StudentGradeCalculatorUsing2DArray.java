//program to calculate student grades using 2D array 

import java.util.Scanner;

class StudentGradeCalculatorUsing2DArray {
    public static void main(String[] args) {
        //create object of Scanner
        Scanner input = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // Create arrays
        int[][] marks = new int[n][3];   // 0-Physics, 1-Chemistry, 2-Maths
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Take input for marks with validation
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";

                System.out.print("Enter marks in " + subject + ": ");
                marks[i][j] = input.nextInt();

                // Validate negative marks
                if (marks[i][j] < 0) {
                    System.out.println("Marks must be positive. Re-enter all marks for this student.");
                    i--;   // decrement index to repeat student input
                    break;
                }
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } 
            else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } 
            else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } 
            else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } 
            else if (percentage[i] >= 40){
                grade[i] = 'E';
            }
            else{
                grade[i] = 'R';
            }
        }

        // Display result
        System.out.println("STUDENT REPORT");
        System.out.printf("%-10s %-10s %-10s %-12s %-10s%n", "Physics", "Chemistry", "Maths", "Percentage", "Grade");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-10d %-10d %-12.2f %-10c%n", marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        //Closing the Scanner Stream
        input.close();
    }
}
