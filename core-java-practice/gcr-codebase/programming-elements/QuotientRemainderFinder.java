//import Scanner class to take input from user
import java.util.Scanner;

class QuotientRemainderFinder{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		int number1,number2;
		
		//take input from user
		number1 = input.nextInt();
		number2 = input.nextInt();
		
		//calculate the results
		int quotient = number1/number2;
		int remainder = number1%number2;
		
		//Display the results
		System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + number1 + " and " + number2);
		input.close();
	}
}