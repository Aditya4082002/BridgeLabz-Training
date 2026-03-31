//import Scanner class to take input from user
import java.util.Scanner;

class LargestNumberCheck{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user for three numbers to compare
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		
		//check for the largest number and display the output
		if(number1>number2 && number1>number3){
			System.out.println("Is the first number the largest? Yes");
			System.out.println("Is the second number the largest? No");
			System.out.println("Is the third number the largest? No");
		}
		else if(number2>number1 && number2>number3) {
			System.out.println("Is the first number the largest? No");
			System.out.println("Is the second number the largest? Yes");
			System.out.println("Is the third number the largest? Yes");
		}
		else{
			System.out.println("Is the first number the largest? No");
			System.out.println("Is the second number the largest? No");
			System.out.println("Is the third number the largest? Yes");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}