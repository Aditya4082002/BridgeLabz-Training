//program to demonstrate IllegalArgumentException
import java.util.Scanner;

class IllegalArgumentExceptionDemo{
	public static void main(String[] args){
		
		handleException();
	}
	
	//method to generate exception
	public static void generateException(){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		String String1 = input.next();
		System.out.println(String1.repeat(-1));
		
		//close scanner stream
		input.close();
	}
	
	//method to handle exception
	public static void handleException(){
		try{
			generateException();
		}
		catch(IllegalArgumentException e){
			System.out.println("IllegalArgumentException handled");
		}
	}
}