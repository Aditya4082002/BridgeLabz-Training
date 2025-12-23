//import Scanner class to take input from user
import java.util.Scanner;

class Factorial{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		
		int number = input.nextInt();
		//check if the user has given a positive number
		if(number>0){
			int tempNumber=number;
			int factorial=1;
		
			//calculating the factorial
			while(tempNumber>0){
				factorial = factorial*tempNumber;
				tempNumber--;
			}
		
			//Display the results
			System.out.println("Factorial of number : " +number+ " is " + factorial);
		}
		else{
			System.out.println("The number is not positive");
		}
		
		
		//Closing the Scanner Stream
		input.close();
	}
}