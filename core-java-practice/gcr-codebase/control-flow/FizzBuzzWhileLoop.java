//import Scanner class to take input from user
import java.util.Scanner;

//create class FizzBuzzWhileLoop
class FizzBuzzWhileLoop{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int number=input.nextInt();
		
		//counter
		int i=1;
		
		//
		while(i<=number){
			if(i%3==0 && i%5==0){
				System.out.println("FizzBuzz");
			}
			else if(i%3==0){
				System.out.println("Fizz");
			}
			else if(i%5==0){
				System.out.println("Buzz");
			}
			else{
				System.out.println(i);
			}
			i++;
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}