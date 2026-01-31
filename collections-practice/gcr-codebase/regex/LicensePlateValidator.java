package regex;

import java.util.Scanner;

public class LicensePlateValidator {
    public static void main(String[] args) {

        // Create scanner object
        Scanner input = new Scanner(System.in);

        // Ask user to enter license plate
        System.out.print("Enter license plate: ");
        String plate = input.nextLine();

        // Regex pattern
        String regex = "^[A-Z]{2}[0-9]{4}$";

        // Check if plate matches pattern
        if (plate.matches(regex)) {
            System.out.println("Valid License Plate");
        } else {
            System.out.println("Invalid License Plate");
        }

        // Close scanner
        input.close();
    }
}

