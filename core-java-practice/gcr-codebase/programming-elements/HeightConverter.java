//import Scanner class to take user input
import java.util.Scanner;

//create class HeightConverter to convert user height from cm to feet and inches
class HeightConverter{
	public static void main(String[] args){
		//create object of Scanner class 
		Scanner input=new Scanner(System.in);
		
		//create variables for heights in cm inches and feet
		double heightInCm, heightInInches, heightInFeet;
		
		//take input from user
		System.out.print("Enter height in cm : ");
		heightInCm=input.nextInt();
		
		//convert the height in inches and feet
		heightInInches=heightInCm/2.54;
		heightInFeet=heightInInches/12;
		
		//Print the calculate results
		System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + heightInFeet + " and inches is " + heightInInches);
		input.close();
	}
}