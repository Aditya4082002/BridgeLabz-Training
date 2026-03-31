//import Scanner class to take input from user
import java.util.Scanner;

class RocketLaunchForLoop{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int number = input.nextInt();
		
		//Display the countdown using For loop
		for(int count=number;count>0;count--){
			System.out.println(count);
			
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}