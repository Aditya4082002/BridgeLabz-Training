package regex;

import java.util.regex.*;
import java.util.Scanner;

public class RepeatingWordFinder {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter sentence
        System.out.println("Enter sentence:");
        String text = input.nextLine();

        // Regex for repeating words
        String regex = "\\b(\\w+)\\s+\\1\\b";

        // Compile pattern (case insensitive)
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        // Create matcher
        Matcher matcher = pattern.matcher(text);

        // Find and print repeated words
        while (matcher.find()) {
            System.out.println(matcher.group(1)); // print the word only
        }

        // Close scanner
        input.close();
    }
}
