//import Scanner class to take input from user
import java.util.Scanner;

class PowerOfNumber{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take number and power as input from user
		int number = input.nextInt();
		int power = input.nextInt();
		int result=1;
		
		for(int i=1;i<=power;i++){
			result=result*number;
		}
		
		//Display the result
		System.out.println(power+ " power of " + number + " = "+ result);
		
		//Closing the Scanner Stream
		input.close();
	}
}