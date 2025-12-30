import java.util.Scanner;

class MaximumOfThree {

    // Function to take input from user
    static int[] takeInput() {
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[3];

        System.out.print("Enter first number: ");
        numbers[0] = input.nextInt();

        System.out.print("Enter second number: ");
        numbers[1] = input.nextInt();

        System.out.print("Enter third number: ");
        numbers[2] = input.nextInt();
        
        input.close();

        return numbers;
    }

    // Function to calculate maximum of three numbers
    static int findMaximum(int a, int b, int c) {

        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {

        // Call input function
        int[] nums = takeInput();

        // Call maximum function
        int maximum = findMaximum(nums[0], nums[1], nums[2]);

        System.out.println("Maximum of the three numbers is: " + maximum);
    }
}
