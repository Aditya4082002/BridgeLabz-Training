//import Scanner class to take input from user
import java.util.Scanner;

class DoubleOpt{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//create variables for values
		double a,b,c;
		
		//take input from user
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		
		//calculate all the operations
		double operation1 = a + b * c;
		double operation2 = a * b + c;
		double operation3 = c + a / b;
		double operation4 = a % b + c;
		//Display the results
		System.out.println(" The results of Double Operations are : " +operation1+ ", " +operation2+ ", " +operation3+ " and " +operation4);
		input.close();
	}
}