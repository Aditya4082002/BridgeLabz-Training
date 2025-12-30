//import Scanner class to take input from user
import java.util.Scanner;

class ReverseString{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take user innput
		System.out.println("Enter String : ");
		String text = input.nextLine();
		
		String reverseString ="";
		
		//loop to reverse string
		for(int i=text.length()-1;i>=0;i--){
			reverseString = reverseString + text.charAt(i); 
		}
		
		//Display result
		System.out.println("String : " + text);
		System.out.println("Reverse String : " + reverseString);
		
		//Closing the Scanner Stream
		input.close();
	}
}
