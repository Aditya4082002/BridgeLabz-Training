//import Scanner class to take input from user
import java.util.Scanner;

//create a class NumbeUntilZero to take input and store numbers until user give zero or negative or the limit reach to 10 and show numbers as well as the sum of numbers
class NumbersUntilZero{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//create array and sum variable to store the sum of numbers
		int[] numbers = new int[10];
		int sum=0;
		
		int index = 0;
		//take input for numbers and check for zero or negative number and stop
		System.out.println("Enter numbers: ");
		while(true){
			int number = input.nextInt();
			if(index>=10 || number<=0){
				break;
			}
			else{
				numbers[index] = number;
			}
			index++;
		}
		
		//for loop to calculate the sum
		for(int i=0;i<numbers.length-1;i++){
			sum = sum + numbers[i];
		}

		
		//show the results
		for(int i=0;i<index;i++){
			System.out.println(numbers[i]);
		}
		System.out.println("total of the numbers : "+ sum);
		
		
		//Closing the Scanner Stream
		input.close();
	}
}