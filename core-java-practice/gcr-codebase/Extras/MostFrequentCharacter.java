package extras;

import java.util.Scanner;

public class MostFrequentCharacter {

	public static void main(String[] args) {
		
		//create scanner object
		Scanner input = new Scanner(System.in);
				
		//take user input
		System.out.print("Enter text : ");
		String text = input.nextLine();
		
		//string to char array
		char[] charArray = text.toCharArray();
		char maxOccur=' ';
		int maxCount=0;
		
		for(char character : charArray) {
			int count=0;
			for(int i =0;i<charArray.length;i++) {
				if(character == charArray[i]) {
					count++;
				}
			}
			if(count>maxCount) {
				maxCount=count;
				maxOccur=character;
			}
		}
		//Display the Results
		System.out.println("Most Frequent Character: " + maxOccur);
				
		//close scanner
		input.close();
		
	}
}