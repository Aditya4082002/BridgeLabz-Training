//import Scanner class to take input from user
import java.util.Scanner;

class QuotientRemainderFinder{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		int sum;
		//take input from user
		int number = input.nextInt();
		
		//check if the number is natural number
		if(number>0){
			sum= number*(number+1)/2;
			System.out.println("The sum of " + number + " natural numbers is "+sum);
		}
		else{
			System.out.println("The Number "+number+" is not a natural number");
		}
		//Closing the Scanner Stream
		input.close();
	}
}