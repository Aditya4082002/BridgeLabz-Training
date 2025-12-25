//program to findd the average of three numbers
import java.util.Scanner;

class Average{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take three numbers input
		System.out.println("Enter First number : ");
		double firstNumber = input.nextDouble();
		System.out.println("Enter Second number : ");
		double secondNumber = input.nextDouble();
		System.out.println("Enter Third number : ");
		double thirdFirstNumber = input.nextDouble();
		
		//calculate the average
		double average = (firstNumber + secondNumber + thirdFirstNumber) / 3;
		
		//display average
		System.out.println("Average : " + average);
		
		//Closing the Scanner Stream
		input.close();
	}
}
