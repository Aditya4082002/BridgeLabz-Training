//program to find area of a circle
import java.util.Scanner;

class AreaOfCircle{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take radius input
		System.out.println("Enter the radius of the circle : ");
		double radius = input.nextDouble();
		final double PI = 3.14;
		
		//calculate the area 
		double area = PI * (radius*radius);
		
		//Display the area
		System.out.println("Area of circle with radius " + radius + " is " + area);
		
		//Closing the Scanner Stream
		input.close();
	}
}