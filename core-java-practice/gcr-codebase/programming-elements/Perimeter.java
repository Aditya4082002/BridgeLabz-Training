//program to find perimeter of a rectangle
import java.util.Scanner;

class Perimeter{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take llength and width input
		System.out.println("Enter length : ");
		int length  = input.nextInt();
		System.out.println("Enter width : ");
		int width = input.nextInt();
		
		//calculate perimeter
		int perimeter = 2 * (length + width);
		
		//display perimeter
		System.out.println("Perimeter : " + perimeter);
		
		//Closing the Scanner Stream
		input.close();
	}
}