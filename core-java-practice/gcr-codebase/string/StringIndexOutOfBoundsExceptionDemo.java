//program to demonstrate StringIndexOutOfBoundsException
import java.util.Scanner;

class StringIndexOutOfBoundsExceptionDemo{
	public static void main(String[] args){
		
		handleException();
		
	}
	
	//method to generate exception
	public static void generateException(){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		String String1 = input.next();
		System.out.println(String1.charAt(11));
		
		//close scanner stream
		input.close();
	}
	
	//method to handle exception
	public static void handleException(){
		try{
			generateException();
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("StringIndexOutOfBoundsException handled");
		}
	}
}