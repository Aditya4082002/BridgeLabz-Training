package exceptions;

import java.util.Scanner;

public class NestedTryCatchExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Sample array
        int[] arr = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter array index: ");
            int index = input.nextInt();

            try {
                int value = arr[index];  // may throw ArrayIndexOutOfBoundsException

                System.out.print("Enter divisor: ");
                int divisor = input.nextInt();

                int result = value / divisor;  // may throw ArithmeticException
                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Error: Can't Divide by zero");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index.");
        } finally {
            input.close();
        }
    }
}
