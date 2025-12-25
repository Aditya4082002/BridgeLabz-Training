//a program that takes two numbers as input from the user and prints their sum.
import java.util.Scanner;

class AddTwoNumbers{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take 2 numbers as input
		System.out.print("Enter first number : ");
		int firstNumber  = input.nextInt();
		System.out.print("Enter Second number : ");
		int secondNumber  = input.nextInt();
		
		//calculate the sum
		int sum = firstNumber + secondNumber;
		
		//display the sum
		System.out.println("Sum of " + firstNumber + " + "+ secondNumber + " = " + sum);
		
		//Closing the Scanner Stream
		input.close();
	}
}