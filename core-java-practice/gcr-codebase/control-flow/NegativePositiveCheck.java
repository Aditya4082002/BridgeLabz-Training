//import Scanner class to take input from user
import java.util.Scanner;

class NegativePositiveChcek{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number for user
		int number = input.nextInt();
		
		//check if the number is negative positive or zero
		if(number>0){
			System.out.println("The Number is Positive");
		}
		else if(number<0){
			System.out.println("The Number is Negative");
		}
		else{
			System.out.println("The Number is Zero");
		}

		//Closing the Scanner Stream
		input.close();
	}
}