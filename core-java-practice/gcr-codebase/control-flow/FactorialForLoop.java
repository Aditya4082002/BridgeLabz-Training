//import Scanner class to take input from user
import java.util.Scanner;

class FactorialForLoop{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int number = input.nextInt();
		//check if the user has given a positive number
		if(number>0){
			int factorial=1;
		
			//calculating the factorial
			for(int i=number;i>0;i--){
				factorial = factorial*i;
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