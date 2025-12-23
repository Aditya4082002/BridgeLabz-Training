//import Scanner class to take user from input
import java.util.Scanner;

//create class DistanceConverterUserInput to convert user given km into miles
class DistanceConverterUserInput{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input = new Scanner(System.in);
		//declare variables for km and miles
		double km,miles;
		
		//take input from user
		km=input.nextInt();
		
		//convert km to miles
		miles=km/1.6;
		
		//display the calculated results
		System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
		input.close();
	}
}