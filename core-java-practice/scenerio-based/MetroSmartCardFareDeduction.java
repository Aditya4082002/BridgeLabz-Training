//program to manage metro smart card
import java.util.Scanner;

class MetroSmartCardFareDeduction{
	public static void main(String[] args){
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//initial balance
		System.out.println("Enter initial balance.");
		int smartCardBalance = input.nextInt();
		
		
		
		while(smartCardBalance>0){
			//input for distance 
			System.out.println("Enter distance or -1 to exit : ");
			int distance = input.nextInt();
			
			//exit condition
			if(distance==-1){
				System.out.println("Thanks for using metro.");
				break;
			}
			
			//calculate fare
			int fare = (distance <= 5)? (distance * 10) : (distance * 8);
			
			if(smartCardBalance>=fare){
				smartCardBalance = smartCardBalance - fare;
				System.out.println("Fare : " + fare);
				System.out.println("Remaining balance : " + smartCardBalance);
			}
			else{
				System.out.println("Insufficient balance.");
				break;
			}
		}
		
		//close scanner stream
		input.close();
	}
}