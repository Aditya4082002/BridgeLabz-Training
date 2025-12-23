//import Scanner class to take input from user
import java.util.Scanner;

class SpringSeason{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take month and day input from user
		int day = input.nextInt();
		int month = input.nextInt();
		
		
		//check if the date lies between March 20 and June 20 and Display the results
		if(month>3 && month<6 ){
			System.out.println("Its a Spring Season");
		}
		else if(month==3 && day>=20){
			System.out.println("Its a Spring Season");
		}
		else if(month==6 && day<=20){
			System.out.println("Its a Spring Season");
		}
		else{
			System.out.println("Not a Spring Season");
		}
		
		
		//Closing the Scanner Stream
		input.close();
	}
}