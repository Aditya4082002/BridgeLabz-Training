//import Scanner class to take input from user
import java.util.Scanner;

class VoteCheck{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		//take user age as input from user
		int age=input.nextInt();
		
		//check if user can vote and display the result
		if(age>=18){
			System.out.println("The person's age is " + age + " and can vote.");
		}
		else{
			System.out.println("The person's age is " + age + " and cannot vote.");
		}
		//Closing the Scanner Stream
		input.close();
	}
}