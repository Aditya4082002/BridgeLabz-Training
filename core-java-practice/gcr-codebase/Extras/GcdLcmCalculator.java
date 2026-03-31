import java.util.Scanner;

class GcdLcmCalculator {

    // Function to take input from user
    static int[] takeInput() {
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[2];

        System.out.print("Enter first number: ");
        numbers[0] = input.nextInt();

        System.out.print("Enter second number: ");
        numbers[1] = input.nextInt();
        input.close();
        return numbers;
    }

    // Function to calculate GCD using recursion
    static int calculateGCD(int firstNumber, int secondNumber) {

        if (secondNumber == 0) {
            return firstNumber;
        }

        return calculateGCD(secondNumber, firstNumber % secondNumber);
    }

    // Function to calculate LCM
    static int calculateLCM(int firstNumber, int secondNumber) {

        int gcd = calculateGCD(firstNumber, secondNumber);
        return (firstNumber * secondNumber) / gcd;
    }

    // Function to display result
    static void displayResult(int firstNumber, int secondNumber, int gcd, int lcm) {

        System.out.println("GCD of " + firstNumber + " and " + secondNumber + " is: " + gcd);
        System.out.println("LCM of " + firstNumber + " and " + secondNumber + " is: " + lcm);
    }

    public static void main(String[] args) {

        int[] nums = takeInput();

        int firstNumber = nums[0];
        int secondNumber = nums[1];

        int gcd = calculateGCD(firstNumber, secondNumber);
        int lcm = calculateLCM(firstNumber, secondNumber);

        displayResult(firstNumber, secondNumber, gcd, lcm);
    }
}
