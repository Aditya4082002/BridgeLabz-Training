package regex;
import java.util.regex.*;
import java.util.Scanner;

public class EmailExtractor {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter text
        System.out.println("Enter text:");
        String text = input.nextLine();

        // Email regex pattern
        String regex = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);

        // Create matcher
        Matcher matcher = pattern.matcher(text);

        // Find all emails
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // Close scanner
        input.close();
    }
}
