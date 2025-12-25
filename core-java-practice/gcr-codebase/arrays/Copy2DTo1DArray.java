//import Scanner class to take input from user
import java.util.Scanner;

//create class Copy2DTo1DArray to copy a 2D array to a 1D array
class Copy2DTo1DArray{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take input for rows and columns
		System.out.print("Enter number of rows : ");
		int rows = input.nextInt();
		System.out.print("Enter number of columns : ");
		int columns = input.nextInt();
		
		//create a 2D array and a 1D array and takke input to 2D array
		int[][] matrix  = new int[rows][columns]; 
		int[] array = new int[rows*columns];
		int index = 0;
		
		System.out.println("Enter Elements for 2D array");
		for(int row=0;row<rows;row++){
			for(int column=0;column<columns;column++){
				matrix[row][column] = input.nextInt();
			}
		}
		
		//copy elements of 2D array to 1D array
		for(int row=0;row<rows;row++){
			for(int column=0;column<columns;column++){
				array[index] = matrix[row][column];
				index++;
			}
		}
		
		//Display the 1D array
		System.out.println("1D array :");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i] + " ");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}