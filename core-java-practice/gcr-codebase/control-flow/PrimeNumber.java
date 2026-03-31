//import Scanner class to take input from user
import java.util.Scanner;

//create a class PrimeNumber to check a number is prime or not
class PrimeNumber{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number from user
		int number=input.nextInt();
		boolean isPrime = true;
		//prime number logic
		if(number>1){
			for(int i=2;i<number;i++){
				if(number%i==0){
					isPrime=false;
					break;
				}
			}
			if(number==2){
				isPrime=true;
			}
		}
		
		if(isPrime==true){
			System.out.println(number + " is a Prime number");
		}
		else{
			System.out.println(number + " is not a Prime number");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}