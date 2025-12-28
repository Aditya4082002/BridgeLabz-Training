import java.util.Scanner;

class NumberAnalysis {
    public static void main(String[] args) {

        //create a scanner object
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];

        // Take user input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\n\tNumber Analysis");

        // Check positive/negative and even/odd
        for (int i = 0; i < numbers.length; i++) {

            int num = numbers[i];

            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            } else {
                System.out.println(num + " is Negative");
            }
        }

        // Compare first and last elements
        int comparison = compare(numbers[0], numbers[numbers.length - 1]);

        System.out.println("\n--- Comparison Result ---");
        if (comparison == 1) {
            System.out.println("First element is greater than last element");
        } else if (comparison == 0) {
            System.out.println("First and last elements are equal");
        } else {
            System.out.println("First element is less than last element");
        }

        //close scanner stream
        input.close();
    }

    // Method to check if number is positive
    static boolean isPositive(int number) {
        return number >= 0;
    }

    // Method to check if number is even
    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Method to compare two numbers
    static int compare(int number1, int number2) {

        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
}
