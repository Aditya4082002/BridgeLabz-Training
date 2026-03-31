//import Scanner class to take input from user
import java.util.Scanner;


//create class PrintTable to print the table of the number
class PrintTable{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int number=input.nextInt();
		
		//for loop to print the table
		for(int i=1;i<=10;i++){
			System.out.println(number+" * "+i+" = "+number*i);
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}