//Program to find the sum of n natural numbers using loop
import java.util.Scanner;

class SumOfNaturalNumbers {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter the value of n: ");
        int n = input.nextInt();

        // Calculate sum
        int sum = findSum(n);

        // Display result
        System.out.println("The sum of first " + n + " natural numbers is " + sum);
        
        //close scanner stream
        input.close();
    }

    // Method to find sum of n natural numbers using loop
    public static int findSum(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }
}