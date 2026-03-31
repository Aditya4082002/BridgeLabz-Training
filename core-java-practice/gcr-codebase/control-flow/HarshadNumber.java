//import Scanner class to take input from user
import java.util.Scanner;

//create a class to check if a number is Harshad or not
class HarshadNumber{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
				
		//take a number from user
		int number = input.nextInt();
		int originalNumber=number;
		int sum=0;
		
		//calculate the sum of digits
		while(number!=0){
			int digit = number%10;
			number=number/10;
			sum=sum+digit;
		}
		
		//check for Harshad Number and showing the results
		if(originalNumber%sum==0){
			System.out.println(originalNumber+" is a Harshad Number." );
		}
		else{
			System.out.println(originalNumber+" is Not a Harshad Number." );
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}