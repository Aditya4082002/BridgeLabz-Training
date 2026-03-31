//import Scanner class to take input from user
import java.util.Scanner;

class PriceClaculator{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		//create variables for unitPrice and quantity
		int unitPrice, quantity;
		
		//take user input
		System.out.print("Enter the unit price : ");
		unitPrice = input.nextInt();
		System.out.print("Enter the quantity : ");
		quantity = input.nextInt();
		
		//calculate the totalPrice
		int totalPrice=unitPrice*quantity;
		
		//Display the results
		System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
		input.close();
	}
}