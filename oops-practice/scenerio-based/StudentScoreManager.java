package scenrioBase;

import java.util.Scanner;

public class StudentScoreManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    sc.next();
                } else {
                    int score = sc.nextInt();
                    if (score < 0) {
                        System.out.println("Score cannot be negative.");
                    } else {
                        scores[i] = score;
                        sum += score;
                        break;
                    }
                }
            }
        }

        double average = (double) sum / n;

        int highest = scores[0];
        int lowest = scores[0];

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        System.out.println();
        System.out.println("Score Analysis");
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        System.out.println();
        System.out.println("Scores Above Average:");

        boolean found = false;
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No scores above average.");
        }

        sc.close();
    }
}
