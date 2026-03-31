//program to find simple intrest
import java.util.Scanner;

class SimpleIntrest{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take principle , rate and time input
		System.out.print("Enter Principle : ");
		double principle = input.nextDouble();
		System.out.print("Enter Rate : ");
		double rate = input.nextDouble();
		System.out.print("Enter time in years : ");
		double time = input.nextDouble();
		
		//calculate simple intrest
		double simpleIntrest = (principle * rate * time)/100;
		
		//display the simple intrest
		System.out.println("Simple intrest = " + simpleIntrest);
		
		//Closing the Scanner Stream
		input.close();
	}
}