//import Scanner class to take input from user
import java.util.Scanner;

//create class PowerOfNumberUsingWhileLoop to calculate the power of number using while loop
class PowerOfNumberUsingWhileLoop{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take number and power as input from user
		int number = input.nextInt();
		int power = input.nextInt();
		
		int result=1;
		int counter=0;
		while(counter<power){
			result=result*number;
			counter++;
		}
		
		//Display the result
		System.out.println(power+ " power of " + number + " = "+ result);
		
		//Closing the Scanner Stream
		input.close();
	}
}