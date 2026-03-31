//program to find and return the length of a string without using the length() method 

import java.util.Scanner;

class LengthOfString{
	public static void main(String[] args){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		//input for string
		System.out.print("Enter String to find length : ");
		String text = input.next();
		
		//method call
		int length = findLegth(text);
		System.out.println("The Length of the string is : " + length);
		
		
		//close scanner stream
		input.close();
	}
	
	public static int findLegth(String text){
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
}