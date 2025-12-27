//Program to split the text into words and find the shortest and longest strings in a given text
import java.util.Scanner;

class ShortestLongestWord {
    public static void main(String[] args) {
        //create Scanner object
        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter text : ");
        String text = input.nextLine();

        // Split words
        String[] words = splitText(text);

        // Create 2D array (word, length)
        String[][] wordData = wordLengthArray(words);

        // Find shortest and longest
        int[] result = findShortestAndLongest(wordData);

        // Display result
        System.out.println("Word\t\tLength");
        System.out.println("------------------------");
        for (int i = 0; i < wordData.length; i++) {
            System.out.println( wordData[i][0] + "\t\t" + wordData[i][1]);
        }

        // Display shortest & longest
        System.out.println("Shortest Word : " + wordData[result[0]][0]);
        System.out.println("Longest Word  : " + wordData[result[1]][0]);

        //close scanner stream
        input.close();
    }

    // Method to find string length without using length()
     public static int findLength(String text){
		int index=0;
		while(true){
			try{
				text.charAt(index);
				index++;
			}
			catch(StringIndexOutOfBoundsException e){
				return index;
			}
		}
	}

    // Method to split text into words without using split()
   public static String[] splitText(String text){
		int length = findLength(text);

		//count number of words
		int wordCOunt = 1;
		for(int i=0;i<length;i++){
			if(text.charAt(i) == ' '){
				wordCOunt++;
			}
		}

		String[] words = new String[wordCOunt];
		String word = "";
		int index=0;
		
		for(int i=0;i<length;i++){
			if(text.charAt(i)==' '){
				words[index] = word;
				index++;
				word="";
			}
			else if(i==length-1){
				word = word + text.charAt(i);
				words[index] = word;
			}
			else{
				word = word + text.charAt(i);
			}
		}
		return words;
	}

    // Method to create 2D array of word and its length
    static String[][] wordLengthArray(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Method to find shortest and longest word indexes
    static int[] findShortestAndLongest(String[][] wordData) {

        int shortestIndex = 0;
        int longestIndex = 0;

        int min = Integer.parseInt(wordData[0][1]);
        int max = Integer.parseInt(wordData[0][1]);

        for (int i = 1; i < wordData.length; i++) {
            int length = Integer.parseInt(wordData[i][1]);

            if (length < min) {
                min = length;
                shortestIndex = i;
            }
            if (length > max) {
                max = length;
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }
}
