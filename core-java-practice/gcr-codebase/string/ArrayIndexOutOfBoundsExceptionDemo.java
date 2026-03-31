//program to demonstrate ArrayIndexOutOfBoundsException

import java.util.Scanner;

class ArrayIndexOutOfBoundsExceptionDemo{
	public static void main(String[] args){
		
		handleException();
		
	}
	
	//method to generate exception
	public static void generateException(){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter names : ");
		String[] names = new String[3];
		for(int i=0;i<3;i++){
			names[i] = input.next();
		}
		System.out.println(names[3]);
		
		//close scanner stream
		input.close();
	}
	
	//method to handle exception
	public static void handleException(){
		try{
			generateException();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException handled");
		}
	}
}