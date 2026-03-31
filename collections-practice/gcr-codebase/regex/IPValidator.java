package regex;

import java.util.Scanner;

public class IPValidator {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter IP
        System.out.print("Enter IPv4 address: ");
        String ip = input.nextLine();

        // IPv4 regex
        String regex =
            "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}" +
            "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";

        // Validate
        if (ip.matches(regex)) {
            System.out.println("Valid IP Address");
        } else {
            System.out.println("Invalid IP Address");
        }

        // Close scanner
        input.close();
    }
}


