package regex;

import java.util.Scanner;

public class HexColorValidator {
    public static void main(String[] args) {

        // Create scanner object
        Scanner input = new Scanner(System.in);

        // Ask user to enter hex color
        System.out.print("Enter hex color code: ");
        String color = input.nextLine();

        // Regex pattern: # followed by 6 hex characters
        String regex = "^#[0-9A-Fa-f]{6}$";

        // Check if color matches pattern
        if (color.matches(regex)) {
            System.out.println("Valid Hex Color");
        } else {
            System.out.println("Invalid Hex Color");
        }

        // Close scanner
        input.close();
    }
}
