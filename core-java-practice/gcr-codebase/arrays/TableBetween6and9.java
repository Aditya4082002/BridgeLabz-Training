//import Scanner class to take input from user
import java.util.Scanner;

//create a class TableUsingArray to store the multiplication of a number in array and the display it
class TableBetween6and9{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number input can create an array to store multiplication of that number
		System.out.println("Enter a number to print table");
		int number=input.nextInt();
		int[] multiplicationResult = new int[10];
		
		//calculate and store the table 
		if(number>=6 && number<=9){
			for(int index=1;index<=multiplicationResult.length;index++){
				multiplicationResult[index-1] = number*index;
			}
			
			//display the result from the array
			for(int index=1;index<=multiplicationResult.length;index++){
				System.out.println(number + " * " + index + " = " + multiplicationResult[index-1]);
			}
		}
		else{
			System.out.println("Number should be between 6 and 9");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}