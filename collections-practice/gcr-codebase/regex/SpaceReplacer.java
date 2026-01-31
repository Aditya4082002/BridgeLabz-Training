package regex;

import java.util.Scanner;

public class SpaceReplacer {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter text
        System.out.println("Enter text:");
        String text = input.nextLine();

        // Replace multiple spaces with single space
        String result = text.replaceAll("\\s{2,}", " ");

        // Print result
        System.out.println("Output:");
        System.out.println(result);

        // Close scanner
        input.close();
    }
}
