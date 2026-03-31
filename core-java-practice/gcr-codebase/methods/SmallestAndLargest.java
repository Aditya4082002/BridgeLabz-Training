//Program to find the smallest and the largest of the 3 numbers.
import java.util.Scanner;

class SmallestAndLargest {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter second number: ");
        int number2 = input.nextInt();

        System.out.print("Enter third number: ");
        int number3 = input.nextInt();

        // Find smallest and largest
        int[] result = findSmallestAndLargest(number1, number2, number3);

        // Display result
        System.out.println("Smallest number is: " + result[0]);
        System.out.println("Largest number is: " + result[1]);
        
        //close scanner stream
        input.close();
    }

    // Method to find smallest and largest of three numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {

        int smallest = number1;
        int largest = number1;

        if (number2 < smallest) {
            smallest = number2;
        }
        if (number3 < smallest) {
            smallest = number3;
        }

        if (number2 > largest) {
            largest = number2;
        }
        if (number3 > largest) {
            largest = number3;
        }
        return new int[]{smallest, largest};
    }
}