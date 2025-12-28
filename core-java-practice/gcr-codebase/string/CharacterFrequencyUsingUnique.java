//Program to find the frequency of characters in a string using unique characters and display the result
import java.util.Scanner;

class CharacterFrequencyUsingUnique {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Find character frequency using unique characters
        String[][] result = findFrequencyUsingUnique(text);

        // Display result
        displayFrequency(result);

        //close scanner stream
        input.close();
    }

    // Method to find unique characters using nested loops
    public static char[] uniqueCharacters(String text) {

        int length = text.length();
        char[] array = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentCharacter = text.charAt(i);
            boolean isUnique = true;

            // Check with previous characters
            for (int j = 0; j < i; j++) {
                if (currentCharacter == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                array[uniqueCount] = currentCharacter;
                uniqueCount++;
            }
        }

        // Create exact-sized array
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = array[i];
        }

        return uniqueChars;
    }

    // Method to find frequency using unique characters
    public static String[][] findFrequencyUsingUnique(String text) {

        // ASCII frequency array
        int[] frequency = new int[256];

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Get unique characters
        char[] uniqueChars = uniqueCharacters(text);

        // Create 2D array for result
        String[][] result = new String[uniqueChars.length][2];

        // Store character and frequency
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequency[ch]);
        }

        return result;
    }

    // Method to display frequency table
    public static void displayFrequency(String[][] data) {

        System.out.println("Character\tFrequency");
        System.out.println("--------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }
}