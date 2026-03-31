import java.util.Scanner;

public class NumberCheckerSecond {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);

        System.out.println("Digit Count: " + count);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        int sum = sumOfDigits(digits);
        System.out.println("\nSum of digits: " + sum);

        double sumOfSquares = sumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits: " + sumOfSquares);

        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));

        int[][] frequency = findDigitFrequency(digits);
        System.out.println("\nDigit\tFrequency");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + "\t" + frequency[i][1]);
            }
        }

        input.close();
    }

    static int countDigits(int number) {

        int count = 0;

        while (number != 0) {
            count++;
            number /= 10;
        }

        return count;
    }

    static int[] storeDigits(int number, int count) {

        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        return digits;
    }

    static int sumOfDigits(int[] digits) {

        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    static double sumOfSquaresOfDigits(int[] digits) {

        double sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    static boolean isHarshadNumber(int number, int[] digits) {

        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    static int[][] findDigitFrequency(int[] digits) {

        int[][] frequency = new int[10][2];

        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }

        for (int d : digits) {
            frequency[d][1]++;
        }

        return frequency;
    }
}
