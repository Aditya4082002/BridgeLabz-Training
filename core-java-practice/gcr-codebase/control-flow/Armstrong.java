//import Scanner class to take input from user
import java.util.Scanner;

//create class Armstrong to check if a number is armstrong or not
class Armstrong{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take number form user
		int number = input.nextInt();
		int sum=0;
		int originalNumber=number;
		
		//calculate sum to check armstrong as sum of cube of digits
		while(originalNumber!=0){
			int digit=originalNumber%10;
			originalNumber=originalNumber/10;
			sum=sum+(digit*digit*digit);
		}
		
		//check for armstrong
		if(number==sum){
			System.out.println(number+" is Armstrong");
		}
		else{
			System.out.println(number+" is Not Armstrong");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}