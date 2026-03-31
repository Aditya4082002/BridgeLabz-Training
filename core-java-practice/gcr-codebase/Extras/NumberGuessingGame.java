import java.util.Scanner;

class NumberGuessingGame {

    // Function to generate computer's guess
    static int generateGuess(int low, int high) {
        return (low + high) / 2;
    }

    // Function to get user feedback
    static String getFeedback(Scanner input) {
        System.out.print("Is the guess high, low, or correct? ");
        return input.next().toLowerCase();
    }

    // Function to update range based on feedback
    static int[] updateRange(int guess, int low, int high, String feedback) {

        if (feedback.equals("high")) {
            high = guess - 1;
        } else if (feedback.equals("low")) {
            low = guess + 1;
        }

        return new int[]{low, high};
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");
        System.out.println("Respond with: high, low, or correct\n");

        while (!guessedCorrectly) {

            int guess = generateGuess(low, high);
            System.out.println("My guess is: " + guess);

            String feedback = getFeedback(input);

            if (feedback.equals("correct")) {
                System.out.println("I guessed your number correctly");
                guessedCorrectly = true;
            } else if (feedback.equals("high") || feedback.equals("low")) {
                int[] range = updateRange(guess, low, high, feedback);
                low = range[0];
                high = range[1];
            } else {
                System.out.println("Invalid input. Please enter high, low, or correct.");
            }
        }

        input.close();
    }
}
