//import Scanner class to take input from user
import java.util.Scanner;

//create class Factors to find and print the factors using while loop
class FactorsUsingWhileLoop{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		
		//take a number from user
		int number=input.nextInt();
		
		//checking and printing factors
		if(number>0){
			int i=1;
			while(i<number){
				if(number%i==0){
					System.out.println(i+" is factor of "+number);
				}
				i++;
			}
		}
		else{
			System.out.println("Number is not positive.");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}
