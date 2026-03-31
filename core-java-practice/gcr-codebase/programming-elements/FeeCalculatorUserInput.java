//import Scanner class to take input input from user
import java.util.Scanner;
//create a class FeeCalculatorUserInput to calculate the discount and final fee to pay
class FeeCalculatorUserInput{
	public static void main(String[] args){
		//create object of scanner class
		Scanner input=new Scanner(System.in);
		
		//create variables to indicate fee and discountPercent
		int fee;
		int discountPercent;
		
		//take input from user
		System.out.print("Enter your fee :");
		fee=input.nextInt();
		
		System.out.print("Enter discountPercent :");
		discountPercent=input.nextInt();
		
		//calculate discount and final fee to pay
		int discount = (fee/100)*discountPercent;
		int feeToPay = fee-discount;
		
		//display the results
		System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+feeToPay);
	}
}