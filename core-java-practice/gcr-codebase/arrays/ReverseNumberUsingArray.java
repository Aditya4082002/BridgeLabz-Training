//program to reverse the numebr using array
import java.util.Scanner;

class ReverseNumberUsingArray{
	public static void main(String[] args){
		//create a scanner object
		Scanner input = new Scanner(System.in);
		
		//take number input
		System.out.println("Enter a number : ");
		int number = input.nextInt();
		
		//count the number of digits
		int numberOfDigits = 0;
		int tempNumber = number;
		while(tempNumber!=0){
			numberOfDigits++;
			tempNumber = tempNumber / 10;
		}
		
		//array to store digits
		int[] digits = new int[numberOfDigits];
		
		//store digits
		tempNumber = number;
		int index = 0;
		while(tempNumber!=0){
			digits[index] = tempNumber % 10;
			tempNumber = tempNumber / 10;
			index++;
		}
		
		//Display reverse number
		System.out.print("Reversed number : ");
		for(int i=0;i<numberOfDigits;i++){
			System.out.print(digits[i]);
		}
		
		//close scanner stream
		input.close();
	}
}