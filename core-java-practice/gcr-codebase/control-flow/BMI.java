//import Scanner class to take input from user
import java.util.Scanner;

//create a class BMI to calculate BMI of a person
class BMI{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take height and weight from user
		double weight = input.nextInt();
		double height = input.nextInt();
		double heightInMeter = height/100;
		
		//calculate BMI
		double bmi = weight/(heightInMeter*heightInMeter);
		
		//chcek for status
		if(bmi<=18.4){
			System.out.println("Underweight");
		}
		else if(bmi>=18.5 && bmi<=24.9){
			System.out.println("Normal");
		}
		else if(bmi>=25.0 && bmi<=39.9){
			System.out.println("Overweight");
		}
		else{
			System.out.println("Obese");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}