//import Scanner class to take input from user
import java.util.Scanner;

class RocketLaunch{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int number = input.nextInt();
		
		//Display the countdown using while loop
		while(number>0){
			System.out.println(number);
			number--;
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}