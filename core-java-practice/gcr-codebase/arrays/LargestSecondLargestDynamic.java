//program to find largest and second largest digit from a number 

import java.util.Scanner;

class LargestSecondLargestDynamic{
	public static void main(String[] args){
		//create a scanner object
		Scanner input = new Scanner(System.in);
		
		//take number input
		System.out.println("Enter a number : ");
		int number = input.nextInt();
		
		int maxDigit = 10;
		int[] digits = new int[maxDigit];
		int index = 0;
		
		//store digits of the number in array
		while(number != 0){
			if(index == maxDigit){
				maxDigit = maxDigit + 10;
				int[] tempDigits = new int[maxDigit]; 
				
				for(int i=0;i<digits.length;i++){
					tempDigits[i] = digits[i];
				}
				digits = tempDigits;
			}
			
			digits[index] = number%10;
			number = number / 10;
			index++;
		}
		
		//declare variables to store largest and secondLargest digits
		int largest = 0;
		int secondLargest = 0;
		
		for(int i=0;i<index;i++){
			if(digits[i] > largest){
				secondLargest = largest;
				largest = digits[i];
			}
			else if(digits[i] > secondLargest && digits[i] != largest){
				secondLargest = digits[i];
			}
		}
		
		//Display results
		System.out.println("Largest digit : " + largest);
		System.out.println("Second largest : " + secondLargest);
		
		//close scanner stream
		input.close();
	}
}