//import Scanner class to take input from user
import java.util.Scanner;

//create  a class LeapYearUsingAndOrOperators to check a year is leap or not
class LeapYearUsingAndOrOperators{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int year =input.nextInt();
		
		//check for Leap year and 
		if(year>=1582){
			if(year%4==0 && year%100 !=0 || year%400==0){
				System.out.println(year+" is a Leap year.");
			}
			else{
				System.out.println(year+" is not a Leap year.");
			}
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}
