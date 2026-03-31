//import Scanner class to take input from user
import java.util.Scanner;

//create a class NumberOfDigits to calculate the number of Digits
class NumberOfDigits{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int number=input.nextInt();
		
		//take a counter to store number of digits
		int numberOfDigits=0;
		
		//create a copy the number
		int originalNumber=number; 
		
		//count the number of digits
		while(number!=0){
			number=number/10;
			numberOfDigits++;
		}
		//Display the results
		System.out.println("Number of digits in "+originalNumber+" is "+numberOfDigits);
		
		
		//Closing the Scanner Stream
		input.close();
	}
}