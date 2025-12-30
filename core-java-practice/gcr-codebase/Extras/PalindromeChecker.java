import java.util.Scanner;

class PalindromeChecker {

    // Function to take input from user
    static String takeInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
       
        return input.nextLine();
    }

    // Function to check if string is palindrome
    static boolean isPalindrome(String text) {

        // Remove spaces and convert to lowercase
        text = text.replace(" ", "").toLowerCase();

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        return text.equals(reversed);
    }

    // Function to display result
    static void displayResult(String text, boolean result) {

        if (result) {
            System.out.println("\"" + text + "\" is a Palindrome");
        } else {
            System.out.println("\"" + text + "\" is NOT a Palindrome");
        }
    }

    public static void main(String[] args) {

        String inputText = takeInput();
        boolean result = isPalindrome(inputText);
        displayResult(inputText, result);
    }
}
