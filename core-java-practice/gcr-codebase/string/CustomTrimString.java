//Program to trim the leading and trailing spaces from a string using the charAt() method 
import java.util.Scanner;

class CustomTrimString {

    public static void main(String[] args) {
        //create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter a string with spaces: ");
        String text = input.nextLine();

        // Custom trim logic
        int[] trimIndexes = findTrimIndexes(text);
        String customTrimmed = createSubstring(text, trimIndexes[0], trimIndexes[1]);

        // Built-in trim
        String builtInTrimmed = text.trim();

        // Compare results
        boolean isSame = compareStrings(customTrimmed, builtInTrimmed);

        // Display results
        System.out.println("Custom Trimmed String   : \"" + customTrimmed + "\"");
        System.out.println("Built-in Trimmed String : \"" + builtInTrimmed + "\"");
        System.out.println("Are both strings equal? : " + isSame);

        //close scanner stream
        input.close();
    }

    // Method to find start and end index after trimming spaces
    static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}