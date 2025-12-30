import java.time.LocalDate;
import java.util.Scanner;

class DateArithmetic {

    // Function to take date input
    static LocalDate takeInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a date (yyyy-mm-dd): ");
        return LocalDate.parse(input.nextLine());
    }

    public static void main(String[] args) {

        LocalDate date = takeInput();

        // Add 7 days
        LocalDate result = date.plusDays(7);

        // Add 1 month
        result = result.plusMonths(1);

        // Add 2 years
        result = result.plusYears(2);

        // Subtract 3 weeks
        result = result.minusWeeks(3);

        System.out.println("Final date after calculations: " + result);
    }
}
