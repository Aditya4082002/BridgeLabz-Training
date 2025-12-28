//Program to take 2 numbers and print their quotient and reminder
import java.util.Scanner;

class QuotientAndRemainder {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the number (dividend): ");
        int number = input.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = input.nextInt();

        // Find quotient and remainder
        int[] result = findRemainderAndQuotient(number, divisor);

        // Display result
        System.out.println("Quotient  : " + result[0]);
        System.out.println("Remainder : " + result[1]);

        //close scanner stream
        input.close();
    }

    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {

        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{quotient, remainder};
    }
}