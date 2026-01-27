package exceptions;

import java.util.Scanner;

public class FinallyExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
 
        try {
            System.out.print("Enter first integer: ");
            int first = input.nextInt();

            System.out.print("Enter second integer: ");
            int second = input.nextInt();

            int result = first / second;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");

        } finally {
            System.out.println("Operation completed");
            input.close();
        }
    }
}

