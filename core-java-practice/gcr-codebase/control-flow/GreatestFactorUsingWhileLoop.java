//import Scanner class to take input from user
import java.util.Scanner;

//create GreatestFactorUsingWhileLoop class to find and print the Greatest factor of a number using while loop beside itself
class GreatestFactorUsingWhileLoop{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number input from user
		int number = input.nextInt();
		int greatestFactor=1;
		int counter=number-1;
		
		while(counter>1){
			if(number%counter==0){
				greatestFactor=counter;
				break;
			}
			counter--;
		}
		
		//Display the results
		System.out.println("Greatest factor of "+number+" is "+greatestFactor);
		//Closing the Scanner Stream
		input.close();
	}
}
