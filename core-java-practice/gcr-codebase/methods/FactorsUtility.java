import java.util.Scanner;

public class FactorsUtility {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        System.out.println("\nGreatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + findSumOfFactors(factors));
        System.out.println("Product of Factors: " + findProductOfFactors(factors));
        System.out.println("Product of Cube of Factors: " + findProductOfCubes(factors));

        input.close();
    }

    static int[] findFactors(int number) {

        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    static int findGreatestFactor(int[] factors) {

        int max = factors[0];

        for (int f : factors) {
            if (f > max) {
                max = f;
            }
        }

        return max;
    }

    static int findSumOfFactors(int[] factors) {

        int sum = 0;

        for (int f : factors) {
            sum += f;
        }

        return sum;
    }

    static long findProductOfFactors(int[] factors) {

        long product = 1;

        for (int f : factors) {
            product *= f;
        }

        return product;
    }

    static double findProductOfCubes(int[] factors) {

        double product = 1;

        for (int f : factors) {
            product *= Math.pow(f, 3);
        }

        return product;
    }
}
