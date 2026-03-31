//import Scanner class to take input from user
import java.util.Scanner;

//create a class OddEven to print odd and even numbers
class OddEven{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int number=input.nextInt();
		
		//check that user has given positive number and print even and odd for each number upto that number
		if(number>=1){
			for(int i=1;i<=number;i++){
				if(i%2==0){
					System.out.println("The number "+ i + " is Even");
				}
				else{
					System.out.println("The number "+ i + " is Odd");
				}
			}
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}