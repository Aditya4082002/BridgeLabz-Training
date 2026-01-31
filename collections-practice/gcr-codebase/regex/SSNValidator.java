package regex;

import java.util.Scanner;

public class SSNValidator {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter SSN
        System.out.print("Enter SSN: ");
        String ssn = input.nextLine();

        // SSN regex
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        // Validate SSN
        if (ssn.matches(regex)) {
            System.out.println("Valid SSN");
        } else {
            System.out.println("Invalid SSN");
        }

        // Close scanner
        input.close();
    }
}
