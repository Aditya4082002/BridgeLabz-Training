//Program to take user input for the age of all 10 students in a class and check whether the student can vote
import java.util.Random;

class VotingEligibility {
    public static void main(String[] args) {

        int numberOfStudents = 10;

        // Generate random ages
        int[] ages = generateRandomAges(numberOfStudents);

        // Check voting eligibility
        String[][] result = checkVotingEligibility(ages);

        // Display result
        displayTable(result);
    }

    // Method to generate random 2-digit ages
    public static int[] generateRandomAges(int number) {

        Random random = new Random();
        int[] ages = new int[number];

        for(int i = 0; i < number; i++) {
            ages[i] = random.nextInt(90) + 10; // 10 to 99
        }
        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {

        String[][] data = new String[ages.length][2];

        for(int i = 0; i < ages.length; i++) {

            data[i][0] = String.valueOf(ages[i]);

            // Validate age
            if(ages[i] >= 18) {
                data[i][1] = "YES";
            } 
            else{
                data[i][1] = "NO";
            }
        }
        return data;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] data) {

        System.out.println("Age\tCan Vote");
        System.out.println("----------------");

        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }
}
