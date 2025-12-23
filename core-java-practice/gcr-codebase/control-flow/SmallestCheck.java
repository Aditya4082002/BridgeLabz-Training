//import Scanner class to take input from user
import java.util.Scanner;

class SmallestCheck{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user for three numbers to compare
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		String result;
		
		//check if the number1 is the smallest
		if(number1<number2 && number1<number3){
			result = "Yes";
		}
		else{
			result = "No";
		}
		
		//Display the results
		System.out.println("Is the first number the smallest? "+result);
		//Closing the Scanner Stream
		input.close();
	}
}