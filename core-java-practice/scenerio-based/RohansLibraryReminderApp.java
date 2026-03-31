import java.util.Scanner;

public class RohansLibraryReminderApp {

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Fine per day for late return
        int finePerDay = 5;

        System.out.println("Rohan’s Library Reminder App");

        // Loop for 5 books
        for (int bookNumber = 1; bookNumber <= 5; bookNumber++) {

            System.out.println("\nBook " + bookNumber);

            // Input due date (as day number)
            System.out.print("Enter due date (day number): ");
            int dueDate = input.nextInt();

            // Input return date (as day number)
            System.out.print("Enter return date (day number): ");
            int returnDate = input.nextInt();

            // Check if book is returned late
            if (returnDate > dueDate) {

                int lateDays = returnDate - dueDate;
                int fineAmount = lateDays * finePerDay;

                System.out.println("Book returned late by " + lateDays + " days.");
                System.out.println("Fine to be paid: " + fineAmount);

            } else {
                System.out.println("Book returned on time. No fine.");
            }
        }

        // Close scanner
        input.close();
    }
}
