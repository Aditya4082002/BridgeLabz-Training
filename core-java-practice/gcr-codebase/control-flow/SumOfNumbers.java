//import Scanner class to take input from user
import java.util.Scanner;

class SumOfNumbers{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		double total=0.0,number=1;
		while(number!=0){
			number=input.nextInt();
			total=total+number;
		}
		
		//Display the results
		System.out.println("The sum of numbers : "+ total);
		//Closing the Scanner Stream
		input.close();
	}
}