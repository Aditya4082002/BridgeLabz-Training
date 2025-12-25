//import Scanner class to take input from user
import java.util.Scanner;

//create a class TableUsingArray to store the multiplication of a number in array and the display it
class TableUsingArray{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number input can create an array to store multiplication of that number
		System.out.println("Enter a number to print table");
		int number=input.nextInt();
		int[] table = new int[10];
		
		//calculate and store the table 
		for(int index=1;index<=table.length;index++){
			table[index-1] = number*index;
		}
		
		//display the result from the array
		for(int index=1;index<=table.length;index++){
			System.out.println(number + " * " + index + " = " + table[index-1]);
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}