//import Scanner class to take input from user
import java.util.Scanner;

class MultiplesBelow100UsingWhileLoop{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number input from user
		int number = input.nextInt();
		
		//check the number is positive and below 100 and printing its multiples
		if(number>0 && number<100){
			int counter=100;
			while(counter>0){
				if(counter%number==0){
					System.out.println(counter+" is multiple of "+ number);
				}
				counter--;
			}
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}
