import java.util.Scanner;

class FibonacciGenerator {

    // Function to generate and print Fibonacci sequence
    static void printFibonacci(int terms) {

        int first = 0, second = 1;

        if (terms <= 0) {
            System.out.println("Please enter a positive number");
            return;
        }

        System.out.println("Fibonacci Sequence:");

        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = input.nextInt();

        // Call the function
        printFibonacci(n);

        input.close();
    }
}
