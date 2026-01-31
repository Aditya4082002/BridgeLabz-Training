package regex;

import java.util.Scanner;

public class CensorWords {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter sentence
        System.out.println("Enter sentence:");
        String text = input.nextLine();

        // List of bad words
        String[] badWords = {"damn", "stupid"};

        // Join words with OR operator
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        // Replace bad words with **** (case insensitive)
        String result = text.replaceAll("(?i)" + regex, "****");

        // Print result
        System.out.println("Output:");
        System.out.println(result);

        // Close scanner
        input.close();
    }
}
