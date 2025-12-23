//import Scanner class to take input from user
import java.util.Scanner;
//create a class TriangleAreaCalculator to calculate the area of triangle
class TriangleAreaCalculator{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		//create variables for base and height
		int base, height;
		
		//take input from user
		System.out.print("Enter the base in cm :");
		base=input.nextInt();
		System.out.print("Enter the height in cm :");
		height=input.nextInt();
		
		//calculate the area in sq cm
		double areaInSqCm = 0.5*base*height;
		
		//convert height and base in inches
		double baseInInches=base/2.54;
		double heightInInches=height/2.54;
		
		//calculate the area in sq in
		double areaInSqIn = 0.5*baseInInches*heightInInches;
		
		//display the results
		System.out.println("The Area of the triangle in sq in is " + areaInSqIn + " and sq cm is " + areaInSqCm);
		input.close();
	}
}