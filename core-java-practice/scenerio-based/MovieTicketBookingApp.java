import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int numberOfCustomers = input.nextInt();

        // Loop for multiple customers
        for (int customer = 1; customer <= numberOfCustomers; customer++) {

            System.out.println("\nCustomer " + customer + " Booking Details");

            int ticketPrice = 0;
            int snackPrice = 0;

            // Ask for movie type
            System.out.print("Enter movie type (1-hollywood, 2-bollywood): ");
            int movieType = input.nextInt();

            // Switch case for movie type pricing
            switch (movieType) {
                case 1:
                    ticketPrice = 350;
                    break;
                case 2:
                    ticketPrice = 250;
                    break;
                default:
                    System.out.println("Invalid movie type! Skipping booking.");
                    continue;
            }

            // Ask for seat type
            System.out.print("Enter seat type (gold/silver): ");
            String seatType = input.next();

            // If condition for seat type pricing
            if (seatType.equalsIgnoreCase("gold")) {
                ticketPrice += 100;
            } else if (seatType.equalsIgnoreCase("silver")) {
                ticketPrice += 50;
            } else {
                System.out.println("Invalid seat type! Skipping booking.");
                continue;
            }

            // Ask for snacks
            System.out.print("Do you want snacks? (yes/no): ");
            String snacksChoice = input.next();

            if (snacksChoice.equalsIgnoreCase("yes")) {
                snackPrice = 80;
            }

            int totalAmount = ticketPrice + snackPrice;

            // Display final bill
            System.out.println("Ticket Price: " + ticketPrice);
            System.out.println("Snacks Price: " + snackPrice);
            System.out.println("Total Amount to Pay: " + totalAmount);
        }

        // Close scanner
        input.close();
    }
}
