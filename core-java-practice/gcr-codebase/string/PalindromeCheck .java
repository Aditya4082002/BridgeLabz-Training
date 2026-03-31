//Program to to check if a text is palindrome
import java.util.Scanner;

class PalindromeCheck {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a text: ");
        String text = input.nextLine();

        // Logic 1: Iterative comparison
        boolean result1 = isPalindromeIterative(text);

        // Logic 2: Recursive comparison
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);

        // Logic 3: Using character arrays
        boolean result3 = isPalindromeUsingArray(text);

        // Display results
        System.out.println("\nPalindrome Check Results:");
        System.out.println("Logic 1 (Iterative)  : " + result1);
        System.out.println("Logic 2 (Recursive)  : " + result2);
        System.out.println("Logic 3 (Char Array) : " + result3);

        //close scanner stream
        input.close();
    }

    // Logic 1: Iterative comparison using start & end index
    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using character arrays
    public static boolean isPalindromeUsingArray(String text) {

        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to reverse string using charAt()
    public static char[] reverseString(String text) {

        int length = text.length();
        char[] reverse = new char[length];
        int index = 0;

        for (int i = length - 1; i >= 0; i--) {
            reverse[index++] = text.charAt(i);
        }

        return reverse;
    }
}