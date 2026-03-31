package extras;
import java.util.Scanner;

class Anagram {
  public static void main(String[] args) {
      //create scanner object
      Scanner input = new Scanner(System.in);

      // Take user input
      System.out.print("Enter first text: ");
      String text1 = input.nextLine();

      System.out.print("Enter second text: ");
      String text2 = input.nextLine();

      // Check anagram
      boolean result = isAnagram(text1, text2);

      // Display result
      if (result) {
          System.out.println("The given texts are ANAGRAMS.");
      } else {
          System.out.println("The given texts are NOT ANAGRAMS.");
      }

      //close scanner stream
      input.close();
  }

  // Method to check if two texts are anagrams
  public static boolean isAnagram(String text1, String text2) {

      // Step 1: Check length
      if (text1.length() != text2.length()) {
          return false;
      }

      // Step 2: Frequency arrays for ASCII characters
      int[] frequencyOne = new int[256];
      int[] frequencyTwo = new int[256];

      // Step 3: Find frequency of characters in both texts
      for (int i = 0; i < text1.length(); i++) {
          char character1 = text1.charAt(i);
          char character2 = text2.charAt(i);

          frequencyOne[character1]++;
          frequencyTwo[character2]++;
      }

      // Step 4: Compare frequencies
      for (int i = 0; i < 256; i++) {
          if (frequencyOne[i] != frequencyTwo[i]) {
              return false;
          }
      }

      return true;
  }
}