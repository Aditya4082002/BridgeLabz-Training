//Program to find the frequency of characters in a string using nested loops 
import java.util.Scanner;

class CharacterFrequencyNested {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Find character frequencies
        String[] result = findCharacterFrequency(text);

        // Display result
        System.out.println("Character Frequency:");
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                System.out.println(result[i]);
            }
        }
        //close scanner stream
        input.close();
    }

    // Method to find frequency using nested loops
    static String[] findCharacterFrequency(String text) {

        // Convert string to character array
        char[] characters = text.toCharArray();

        int length = characters.length;
        int[] frequency = new int[length];

        // Nested loop to find frequency
        for (int i = 0; i < length; i++) {
            if (characters[i] == '0') {
                continue;
            }

            frequency[i] = 1;

            for (int j = i + 1; j < length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '0'; // mark duplicate
                }
            }
        }

        // Create 1D String array to store result
        String[] result = new String[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (characters[i] != '0') {
                result[index] =
                    characters[i] + " -> " + frequency[i];
                index++;
            }
        }

        return result;
    }
}
