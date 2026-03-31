//import Scanner class to take input from user
import java.util.Scanner;

//create YoungestAndTallest class to find the youngest and Tallest among three friends
class YoungestAndTallest{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take Age and Height of three friends as input from user
		int AmarAge = input.nextInt();
		int AkbarAge = input.nextInt();
		int AnthonyAge = input.nextInt();
		
		int AmarHeight = input.nextInt();
		int AkbarHeight = input.nextInt();
		int AnthonyHeight = input.nextInt();
		
		
		//Find and Display the results
		if(AmarAge<AkbarAge && AmarAge<AnthonyAge){
			System.out.println("Amar is the youngets among the three.");
		}
		else if(AkbarAge<AmarAge && AkbarAge<AnthonyAge){
			System.out.println("Akbar is the youngest among the three.");
		}
		else{
			System.out.println("Anthony is the youngest among the three.");
		}
		
		if(AmarHeight>AkbarHeight && AmarHeight>AnthonyHeight){
			System.out.println("Amar is the Tallest among the three.");
		}
		else if(AkbarHeight>AnthonyHeight && AkbarHeight>AnthonyHeight){
			System.out.println("Akbar is the Tallest among the three.");
		}
		else{
			System.out.println("Anthony is the Tallest among the three.");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}