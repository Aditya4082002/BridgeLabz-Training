//program to calculator power without loops or conditionals
import java.util.Scanner;

class PowerCalculator{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take number and power input
		System.out.print("Enter base : ");
		double base = input.nextInt();
		System.out.print("Enter exponent : ");
		double exponent = input.nextInt();
		
		//calculate power
		double power  = Math.pow(base,exponent);
		
		//display power 
		System.out.println(power);
		
		//Closing the Scanner Stream
		input.close();
	}
}