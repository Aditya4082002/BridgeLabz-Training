//Program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string
import java.util.Scanner;

class VowelConsonantCounter {
    public static void main(String[] args) {
        //create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Get counts
        int[] count = countVowelsAndConsonants(text);

        // Display result
        System.out.println("Vowels Count     : " + count[0]);
        System.out.println("Consonants Count : " + count[1]);
        
        //close scanner stream
        input.close();
    }

    // Method to check character type
    static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {

            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } 
            else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to count vowels and consonants using charAt()
    static int[] countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            String result = checkCharacter(character);

            if (result.equals("Vowel")) {
                vowels++;
            } 
            else if (result.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
}
