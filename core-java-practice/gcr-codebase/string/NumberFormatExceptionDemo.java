//program to demonstrate NumberFormatException
import java.util.Scanner;

class NumberFormatExceptionDemo{
	public static void main(String[] args){
		
		handleException();
	}
	
	//method to generate exception
	public static void generateException(){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		String string1 = input.next();
		System.out.println(Integer.parseInt(string1));
		
		//close scanner stream
		input.close();
	}
	
	//method to handle exception
	public static void handleException(){
		try{
			generateException();
		}
		catch(NumberFormatException e){
			System.out.println("NumberFormatException handled");
		}
	}
}