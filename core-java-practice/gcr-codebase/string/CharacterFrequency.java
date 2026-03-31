//Program to find the frequency of characters in a string using the charAt() method and display the result
import java.util.Scanner;

class CharacterFrequency {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Get character frequency data
        String[][] frequencyData = findCharacterFrequency(text);

        // Display result
        displayFrequency(frequencyData);

        //close scanner stream
        input.close();
    }

    // Method to find frequency of characters using charAt()
    static String[][] findCharacterFrequency(String text) {

        // Frequency array for 256 ASCII characters
        int[] frequency = new int[256];

        //Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            frequency[character]++;
        }

        //Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (frequency[character] > 0) {
                uniqueCount++;
                frequency[character] = -frequency[character]; // mark as counted
            }
        }

        //sCreate 2D array for character & frequency
        String[][] result = new String[uniqueCount][2];

        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int ascii = character;

            if (frequency[ascii] < 0) {
                result[index][0] = String.valueOf(character);
                result[index][1] = String.valueOf(-frequency[ascii]);
                frequency[ascii] = 0; // avoid duplicate entry
                index++;
            }
        }
        return result;
    }

    // Method to display the frequency table
    static void displayFrequency(String[][] data) {

        System.out.println("\nCharacter\tFrequency");
        System.out.println("--------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }
}