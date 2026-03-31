//import Scanner class to take input from user
import java.util.Scanner;

//create class Factors to find and print the factors using for loop
class Factors{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		
		//take a number from user
		int number=input.nextInt();
		
		//checking and printing factors
		if(number>0){
			for(int i=1;i<number;i++){
				if(number%i==0){
					System.out.println(i+" is factor of "+number);
				}
			}
		}
		else{
			System.out.println("Number is not positive.");
		}
	
		//Closing the Scanner Stream
		input.close();
	}
}
