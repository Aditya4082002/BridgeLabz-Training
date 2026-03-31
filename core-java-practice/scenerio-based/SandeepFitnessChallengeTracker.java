import java.util.Scanner;

public class SandeepFitnessChallengeTracker {

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Array to store push-up counts for 7 days
        int[] weeklyPushUps = new int[7];

        System.out.println("Sandeep’s Fitness Challenge Tracker");

        // Input push-ups for each day
        for (int day = 0; day < weeklyPushUps.length; day++) {

            System.out.print("Enter push-ups for Day " + (day + 1) + " (enter 0 if rest day): ");

            weeklyPushUps[day] = input.nextInt();
        }

        int totalPushUps = 0;
        int activeDays = 0;

        // for-each loop to calculate total and average
        for (int dailyCount : weeklyPushUps) {

            // Skip rest days
            if (dailyCount == 0) {
                continue;
            }

            totalPushUps += dailyCount;
            activeDays++;
        }

        // Calculate average push-ups (avoid division by zero)
        double averagePushUps = (activeDays > 0) ? (double) totalPushUps / activeDays : 0;

        // Display results
        System.out.println("\nTotal push-ups completed: " + totalPushUps);
        System.out.println("Average push-ups per active day: " + averagePushUps);

        // Close scanner
        input.close();
    }
}
