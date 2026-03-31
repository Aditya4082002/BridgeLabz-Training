import java.time.LocalDate;
import java.util.Scanner;

class DateComparison {

    // Function to take date input
    static LocalDate takeDateInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message + " (yyyy-mm-dd): ");
        return LocalDate.parse(input.nextLine());
    }

    public static void main(String[] args) {

        LocalDate date1 = takeDateInput("Enter first date");
        LocalDate date2 = takeDateInput("Enter second date");

        if (date1.isBefore(date2)) {
            System.out.println("The first date is BEFORE the second date.");
        } 
        else if (date1.isAfter(date2)) {
            System.out.println("The first date is AFTER the second date.");
        } 
        else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the SAME.");
        }
    }
}
