//A program to convert cesius to fahrenheit
import java.util.Scanner;

class CelsiustoFahrenheit{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take tempreture input in celsius
		System.out.println("Enter temperature in celsius : ");
		double celsius = input.nextDouble();
		
		//convert celsius to fahrenheit
		double fahrenheit = (celsius * 9/5)+32;
		
		//Display the result
		System.out.println("Temperature in fahrenheit : " + fahrenheit);
		
		//Closing the Scanner Stream
		input.close();
	}
}