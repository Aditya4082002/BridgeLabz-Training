import java.util.Scanner;

class PrimeNumberChecker {

    // Function to check if a number is prime
    static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        // Call the function
        boolean result = isPrime(num);

        if (result) {
            System.out.println(num + " is a Prime Number");
        } else {
            System.out.println(num + " is NOT a Prime Number");
        }

        input.close();
    }
}
