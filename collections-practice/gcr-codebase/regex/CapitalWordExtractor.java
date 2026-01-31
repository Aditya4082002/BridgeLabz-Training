package regex;
import java.util.regex.*;
import java.util.Scanner;

public class CapitalWordExtractor {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter sentence
        System.out.println("Enter sentence:");
        String text = input.nextLine();

        // Regex for capitalized words
        String regex = "\\b[A-Z][a-zA-Z]*\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);

        // Create matcher
        Matcher matcher = pattern.matcher(text);

        // Find and print words
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // Close scanner
        input.close();
    }
}
