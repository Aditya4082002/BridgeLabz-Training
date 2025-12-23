//import Scanner class to take input from user
import java.util.Scanner;

class DistanceConverterYard{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		//create variable for Distance
		System.out.print("Enter the distance in feet :");
		double distance = input.nextDouble();
		
		//convert the distance
		double yards = distance/3;
		double miles = yards/1760;
		//Display the results
		System.out.println("he distance in yards is " + yards + " while the distance in miles is " + miles);
		input.close();
	}
}