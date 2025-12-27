//Program to split the text into words, compare the result with the split() method and display the result
import java.util.Scanner;

class SplitTextToWords{
	public static void main(String[] args){
		//create Scanner object
		Scanner input = new Scanner(System.in);
	
		//input for string
		System.out.print("Enter a String : ");
		String text = input.nextLine();
		
		//split using user defined method
		String[] customWords = splitText(text);

		//split using built in method
		String[] splitWords = text.split(" ");
		
		// Display results
		System.out.println("Words using user defined split method :");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("Words using built-in split() method:");
        for (String word : splitWords) {
            System.out.println(word);
        }

		// Compare results
        boolean result = compareArrays(customWords, splitWords);

        System.out.println("Are both results same? " + result);

		//close scanner stream
		input.close();
	}
	
	//method to find the length of the string
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

	// Method to compare two String arrays
	public static boolean compareArrays(String[] customWords, String[] splitWords) {

        if (customWords.length != splitWords.length) {
            return false;
        }

        for (int i = 0; i < customWords.length; i++) {
            if (!customWords[i].equals(splitWords[i])) {
                return false;
            }
        }
        return true;
    }
}