//import Scanner class to take input from user
import java.util.Scanner;

//create GreatestFactor class to find and print the Greatest factor of a number beside itself
class GreatestFactor{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number input from user
		int number = input.nextInt();
		int greatestFactor=1;
		for(int i=number-1;i>1;i--){
			if(number%i==0){
				greatestFactor=i;
				break;
			}
		}
		
		//Display the results
		System.out.println("Greatest factor of "+number+" is "+greatestFactor);
		//Closing the Scanner Stream
		input.close();
	}
}
