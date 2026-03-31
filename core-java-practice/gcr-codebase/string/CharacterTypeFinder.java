//a program to find vowels and consonants in a string and display the character type - Vowel, Consonant, or Not a Letter
import java.util.Scanner;

class CharacterTypeFinder {
    public static void main(String[] args) {
        //create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Find character types
        String[][] charData = findCharacterTypes(text);

        // Display result
        displayTable(charData);
        
        //close scanner stream
        input.close();
    }

    // Method to check character type
    public static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if letter
        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to find character types using charAt()
    public static String[][] findCharacterTypes(String text) {

        int length = text.length();
        String[][] result = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacter(ch);
        }
        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] data) {

        System.out.println("Character\tType");
        System.out.println("---------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }
}
