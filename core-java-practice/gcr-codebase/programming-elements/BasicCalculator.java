//import Scanner class to take input from user
import java.util.Scanner;

//create a class BasicCalculator to perform all operations
class BasicCalculator{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		//declare variables for both numbers
		int number1,number2;
		
		//take input from user
		System.out.print("Enter 1st number : ");
		number1 = input.nextInt();
		System.out.print("Enter 2nd number : ");
		number2 = input.nextInt();
		
		//perform all operations and store results in respective variables
		int addition=number1+number2;
		int subtraction= number1-number2;
		int multiplication = number1*number2;
		double division = number1/number2;
		
		//print the results
		System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers "+ number1 +" and "+ number2 +" is "
		+ addition +", "+ subtraction +", "+ multiplication +" and "+ division);
		
		input.close();
	}
}