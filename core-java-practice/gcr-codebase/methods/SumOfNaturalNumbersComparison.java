//program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2
import java.util.Scanner;

class SumOfNaturalNumbersComparison {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check if natural number
        if (number <= 0) {
            System.out.println("Not a natural number.");
            input.close();
            return;
        }

        // Calculate sum using recursion
        int recursiveSum = sumUsingRecursion(number);

        // Calculate sum using formula
        int formulaSum = sumUsingFormula(number);

        // Display results
        System.out.println("Sum using recursion : " + recursiveSum);
        System.out.println("Sum using formula   : " + formulaSum);

        // Compare results
        if (recursiveSum == formulaSum) {
            System.out.println("Both computations are Equal.");
        } else {
            System.out.println("Results do NOT match.");
        }
        //close scanner stream
        input.close();
    }

    // Method to find sum using recursion
    static int sumUsingRecursion(int number) {

        if (number == 1) {
            return 1;
        }
        return number + sumUsingRecursion(number - 1);
    }

    // Method to find sum using formula
    static int sumUsingFormula(int n) {

        return n * (n + 1) / 2;
    }
}
