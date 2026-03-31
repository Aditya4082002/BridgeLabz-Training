//program for rock paper scissors game with computer
import java.util.Scanner;

class RockPaperScissors {
    public static void main(String[] args) {
        //create Scanner object
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = input.nextInt();

        String[][] gameResults = new String[games][4];
        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < games; i++) {

            System.out.println("Game " + (i + 1));
            System.out.print("Enter choice (rock / paper / scissors): ");
            String userChoice = input.next().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }

            gameResults[i][0] = String.valueOf(i + 1);
            gameResults[i][1] = userChoice;
            gameResults[i][2] = computerChoice;
            gameResults[i][3] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, games);

        displayResults(gameResults, stats);
        
        //close scanner stream
        input.close();
    }

    // Method to get computer choice using Math.random()
    static String getComputerChoice() {

        int choice = (int)(Math.random() * 3);

        if (choice == 0)
            return "rock";
        else if (choice == 1)
            return "paper";
        else
            return "scissors";
    }

    // Method to find winner
    static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        }

        return "Computer";
    }

    // Method to calculate wins and percentage
    static String[][] calculateStats(int userWins, int computerWins, int totalGames) {

        String[][] stats = new String[2][3];

        double userPercent = (userWins * 100.0) / totalGames;
        double computerPercent = (computerWins * 100.0) / totalGames;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercent);

        return stats;
    }

    // Method to display results
    static void displayResults(String[][] games, String[][] stats) {

        System.out.println("----- GAME RESULTS -----");
        System.out.println("Game\tUser\tComputer\tWinner");
        System.out.println("--------------------------------------");

        for (int i = 0; i < games.length; i++) {
            System.out.println( games[i][0] + "\t" + games[i][1] + "\t" + games[i][2] + "\t\t" + games[i][3] );
        }

        System.out.println("----- WIN STATISTICS -----");
        System.out.println("Player\tWins\tWinning %");
        System.out.println("------------------------------");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] );
        }
    }
}