//Program to check whether a number is positive, negative, or zero.
import java.util.Scanner;

class NumberSignCheck {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take integer input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check number sign
        int result = checkNumber(number);

        // Display result
        if (result == 1) {
            System.out.println("The number is Positive.");
        } else if (result == -1) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }

        //close scanner stream
        input.close();
    }

    // Method to check number sign
    static int checkNumber(int num) {

        if (num > 0) {
            return 1;      // Positive
        } else if (num < 0) {
            return -1;     // Negative
        } else {
            return 0;      // Zero
        }
    }
}