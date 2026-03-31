import java.util.Scanner;

class FactorsOfNumber {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Find factors
        int[] factors = findFactors(number);

        // Display factors
        System.out.print("Factors are: ");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }

        // Calculate results
        int sum = findSumOfFactors(factors);
        long product = findProductOfFactors(factors);
        double sumOfSquares = findSumOfSquares(factors);

        // Display results
        System.out.println("\nSum of factors: " + sum);
        System.out.println("Sum of squares of factors: " + sumOfSquares);
        System.out.println("Product of factors: " + product);
        
        //close scanner stream
        input.close();
    }

    // Method to find factors and return as array
    public static int[] findFactors(int number) {

        int count = 0;

        //count factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Create array with factor count
        int[] factors = new int[count];
        int index = 0;

        //store factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to find sum of factors
    public static int findSumOfFactors(int[] factors) {

        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }
        return sum;
    }

    // Method to find product of factors
    public static long findProductOfFactors(int[] factors) {

        long product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }
        return product;
    }

    // Method to find sum of squares of factors
    public static double findSumOfSquares(int[] factors) {

        double sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += Math.pow(factors[i], 2);
        }
        return sum;
    }
}