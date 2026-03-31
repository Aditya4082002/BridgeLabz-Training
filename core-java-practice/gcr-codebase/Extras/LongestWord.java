//Java program that takes a sentence as input and returns the longest word in thesentence.
//import Scanner class to take input from user
import java.util.Scanner;

class LongestWord{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take user innput
		System.out.println("Enter String : ");
		String text = input.nextLine();
		
		String[] wordArray = text.split(" ");
		int index = 0;
		
		for(int i=0;i<wordArray.length;i++){
			if(wordArray[i].length()>wordArray[index].length()){
				index = i;
			}
		}
		//Display result
		System.out.println("Longest word in String is : " + wordArray[index] );
		
		//Closing the Scanner Stream
		input.close();
	}
}