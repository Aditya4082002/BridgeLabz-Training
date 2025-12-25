//import Scanner class to take input from user
import java.util.Scanner;

class CoffeeCounterChronicles{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		final double GST_RATE = 0.1;
		double price =0;
		
		while(true){
			//Ask for coffee type
			System.out.println("Enter coffee type (espresso/latte/cappuccino) or type 'exit' to stop : ");
			String coffeeType = input.next();
			
			if(coffeeType.equals("exit")){
				System.out.println("Thank you.");
				break;
			}
			
			//enter quantity
			System.out.println("Enter Quantity : ");
			int quantity = input.nextInt();
			
			//switch for coffee type
			switch(coffeeType){
				case "espresso":
					price = 100;
					break;
				case "latte":
					price = 150;
					break;
				case "cappuccino":
					price = 200;
					break;
				default:
					System.out.println("Invalid coffee type.");
					continue;
			}
			
			//calculate bill
			double totalAmount = price * quantity;
			double gst = totalAmount * GST_RATE;
			double totalBill = totalAmount + gst;
			
			//Display Bill
			System.out.println("Total Amount : " + totalAmount);
			System.out.println("GST (10%) : " + gst);
			System.out.println("Final Bill : " + totalBill);
			
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}