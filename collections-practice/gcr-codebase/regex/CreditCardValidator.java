package regex;
import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Ask user to enter card number
        System.out.print("Enter credit card number: ");
        String card = input.nextLine();

        // Regex for Visa or MasterCard
        String regex = "^(4\\d{15}|5\\d{15})$";

        // Validate
        if (card.matches(regex)) {
            System.out.println("Valid Credit Card");
        } else {
            System.out.println("Invalid Credit Card");
        }

        // Close scanner
        input.close();
    }
}
