//program to find unique characters in a string using the charAt() method and display the result
import java.util.Scanner;

class UniqueCharacters {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Find unique characters
        char[] uniqueChars = findUniqueCharacters(text);

        // Display result
        System.out.println("Unique Characters:");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + " ");
        }

        //close scanner stream
        input.close();
    }

    // Method to find string length without using length()
    public static int findLength(String text) {

        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueCharacters(String text) {

        int length = findLength(text);

        // Temporary array to store unique characters
        char[] uniqueArray = new char[length];
        int uniqueCount = 0;

        // Outer loop for each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            // Inner loop to check if already appeared
            for (int j = 0; j < i; j++) {
                if (currentChar == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            // Store if unique
            if (isUnique) {
                uniqueArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // Create exact-sized array for unique characters
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = uniqueArray[i];
        }
        return result;
    }
}