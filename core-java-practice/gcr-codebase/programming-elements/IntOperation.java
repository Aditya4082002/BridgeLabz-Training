//import Scanner class to take input from user
import java.util.Scanner;

class IntOperation{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//create variables for values
		int a,b,c;
		
		//take input from user
		a=input.nextInt();
		b=input.nextInt();
		c=input.nextInt();
		
		//calculate all the operations
		int operation1 = a + b * c;
		int operation2 = a * b + c;
		int operation3 = c + a / b;
		int operation4 = a % b + c;
		//Display the results
		System.out.println(" The results of Int Operations are : " +operation1+ ", " +operation2+ ", " +operation3+ " and " +operation4);
		input.close();
	}
}