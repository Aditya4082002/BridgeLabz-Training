package regex;

import java.util.regex.*;
import java.util.Scanner;

public class DateExtractor {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter text
        System.out.println("Enter text:");
        String text = input.nextLine();

        // Regex for dd/mm/yyyy
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);

        // Create matcher
        Matcher matcher = pattern.matcher(text);

        // Find and print dates
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // Close scanner
        input.close();
    }
}
