// program to create a deck of cards
import java.util.Scanner;

class DeckOfCards {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        };

        int numOfCards = suits.length * ranks.length;

        // Initialize deck
        String[] deck = initializeDeck(suits, ranks);

        // Shuffle deck
        shuffleDeck(deck);

        // Take user input
        System.out.print("Enter number of players: ");
        int players = input.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = input.nextInt();

        // Distribute cards
        String[][] distributedCards = distributeCards(deck, players, cardsPerPlayer);

        // Print players and their cards
        printPlayersCards(distributedCards);

        //close scanner stream
        input.close();
    }

    // Method to initialize the deck
    static String[] initializeDeck(String[] suits, String[] ranks) {

        int index = 0;
        String[] deck = new String[suits.length * ranks.length];

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }
        return deck;
    }

    // Method to shuffle the deck
    static void shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));

            // Swap cards
            String tempCard = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = tempCard;
        }
    }

    // Method to distribute cards to players
    static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {

        int totalCardsNeeded = players * cardsPerPlayer;

        if (totalCardsNeeded > deck.length) {
            System.out.println(
                "Not enough cards to distribute."
            );
            return new String[0][0];
        }

        String[][] result =
                new String[players][cardsPerPlayer];

        int cardIndex = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                result[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        return result;
    }

    // Method to print players and their cards
    static void printPlayersCards(String[][] playersCards) {

        System.out.println("--- Cards Distribution ---");

        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < playersCards[i].length; j++) {
                System.out.println(playersCards[i][j]);
            }
        }
    }
}