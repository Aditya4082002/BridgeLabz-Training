import java.util.Scanner;

public class StudentVoteChecker {
    public static void main(String[] args) {
        //create object of scanner
        Scanner input = new Scanner(System.in);

        
        int[] ages = new int[10];

        // Loop to take input and check voting eligibility
        for (int i = 0; i < ages.length; i++) {

            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = input.nextInt();

            boolean canVote = canStudentVote(ages[i]);

            if (canVote) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }
        //close scanner stream
        input.close();
    }

    // Method to check if a student can vote
    public static boolean canStudentVote(int age) {

        // Validate negative age
        if (age < 0) {
            return false;
        }

        // Check voting eligibility
        if (age >= 18) {
            return true;
        }

        return false;
    }
}
