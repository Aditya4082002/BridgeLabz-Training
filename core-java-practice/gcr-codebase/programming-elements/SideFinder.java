//import Scanner class to take input from user
import java.util.Scanner;
class SideFinder{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		//create variable for perimeter
		int perimeter;
		//take input from user
		System.out.print("Enter the Perimeter : ");
		perimeter=input.nextInt();
		
		//calculate the side
		int side=perimeter/4;
		
		//display the result
		System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
		
		input.close();
	}
}