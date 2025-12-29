import java.util.Scanner;

public class FestivalLuckyDraw {

    public static void main(String[] args) {

        //create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of visitors: ");
        int numberOfVisitors = input.nextInt();

        // Loop for each visitor
        for (int visitorCount = 1; visitorCount <= numberOfVisitors; visitorCount++) {

            System.out.println("Visitor " + visitorCount);

            System.out.print("Enter lucky draw number: ");

            int luckyNumber = input.nextInt();

            // Check if number is divisible by both 3 and 5
            if (luckyNumber % 3 == 0 && luckyNumber % 5 == 0) {
                System.out.println("Congratulations You won a gift!");
            } else {
                System.out.println("Sorry Better luck next time.");
            }
        }

        // Close scanner
        input.close();
    }
}