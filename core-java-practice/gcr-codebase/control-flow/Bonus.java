//import Scanner class to take input from user
import java.util.Scanner;

//create a class bonus to calcluate and print the bonus
class Bonus{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int salary=input.nextInt();
		int year=input.nextInt();
		
		//check for bonus
		if(year>5){
			int bonus=(salary/100)*5;
			System.out.println("Bonus = "+bonus);
		}
		else{
			System.out.println("Bonus only available after 5 year of service");
		}
		//Closing the Scanner Stream
		input.close();
	}
}