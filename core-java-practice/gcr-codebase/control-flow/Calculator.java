//import Scanner class to take input from user
import java.util.Scanner;

//create a class Calculator to perform all arithematic operations
class Calculator{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		double first = input.nextInt();
		double second = input.nextInt();
		String op=input.next();
		double result;
		
		//Switch case
		switch(op){
			case "+":
				result=first+second;
				System.out.println(first+" + "+second+" = "+result);
				break;
			case "-":
				result=first-second;
				System.out.println(first+" - "+second+" = "+result);
				break;
			case "*":
				result=first*second;
				System.out.println(first+" * "+second+" = "+result);
				break;
			case "/":
				result=first/second;
				System.out.println(first+" / "+second+" = "+result);
				break;
			default:
				System.out.println("Invalid Operator");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}