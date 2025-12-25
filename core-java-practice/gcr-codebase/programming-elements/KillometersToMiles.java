//program to convert distance from kilometers to miles
import java.util.Scanner;

class KillometersToMiles{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take distance input in kilometers
		System.out.println("Enter the distance in kilometers : ");
		double kilometers = input.nextDouble();
		
		//convert the distance from kilometers from miles
		double miles = kilometers * 0.621371;
		
		//display the distance in miles
		System.out.println(kilometers + " km = " + miles + "miles");
		
		//Closing the Scanner Stream
		input.close();
	}
}