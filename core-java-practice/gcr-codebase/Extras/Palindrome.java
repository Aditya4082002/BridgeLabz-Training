//program to check if a given string is a palindrome
import java.util.Scanner;
class Palindrome{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take user innput
		System.out.println("Enter String : ");
		String text = input.nextLine();
		
		int start=0;
		int end = text.length()-1;
		
		boolean isPalindrome = true;
		
		while(start<end){
			if(text.charAt(start) != text.charAt(end)){
				isPalindrome = false;
				break;
			}
			start++;
			end--;
		}
		
		if(isPalindrome){
			System.out.println("String is Palindrome.");
		}
		else{
			System.out.println("String is Not Palindrome.");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}