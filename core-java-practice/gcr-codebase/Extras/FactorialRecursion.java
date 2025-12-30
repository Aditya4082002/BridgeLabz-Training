import java.util.Scanner;

class FactorialRecursion {

    // Function to take input from user
    static int takeInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        
        return input.nextInt();
    }

    // Recursive function to calculate factorial
    static long factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // Function to display result
    static void displayResult(int number, long result) {
        System.out.println("Factorial of " + number + " is: " + result);
    }

    public static void main(String[] args) {

        int number = takeInput();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers");
        } else {
            long result = factorial(number);
            displayResult(number, result);
        }
    }
}
