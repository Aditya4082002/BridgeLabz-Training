//program to find the first non-repeating character in a string and show the result
import java.util.Scanner;

class FirstNonRepeatingCharacter {
        public static void main(String[] args) {
            
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Find first non-repeating character
        char result = findFirstNonRepeatingCharacter(text);

        // Display result
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        //close scanner stream
        input.close();
    }

    // Method to find first non-repeating character using charAt()
    public static char findFirstNonRepeatingCharacter(String text) {

        // Frequency array for 256 ASCII characters
        int[] frequency = new int[256];

        //Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        //Find first character with frequency = 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }
        // If no non-repeating character
        return '\0';
    }
}