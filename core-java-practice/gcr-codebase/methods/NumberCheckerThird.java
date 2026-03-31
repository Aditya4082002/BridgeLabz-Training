import java.util.Scanner;

public class NumberCheckerThird {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);
        int[] reversedDigits = reverseDigits(digits);

        System.out.println("Digit Count: " + count);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.print("\nReversed Digits: ");
        for (int d : reversedDigits) {
            System.out.print(d + " ");
        }

        System.out.println("\nArrays Equal: " + compareArrays(digits, reversedDigits));
        System.out.println("Is Palindrome Number: " + isPalindrome(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));

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

    static int[] reverseDigits(int[] digits) {

        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }

        return reversed;
    }

    static boolean compareArrays(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    static boolean isPalindrome(int[] digits) {

        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }

    static boolean isDuckNumber(int[] digits) {

        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }
}
