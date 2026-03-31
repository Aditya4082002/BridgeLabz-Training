//import Scanner class to take input from user
import java.util.Scanner;

//create a class AbundantNumber to check if a  number is Abundant or not
class AbundantNumber{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number form user
		int number = input.nextInt();
		int sum=0;
		
		for(int i=1;i<number;i++){
			if(number%i==0){
				sum=sum+i;
			}
		}
		
		if(sum>number){
			System.out.println(number+" is an Abundant number");
		}
		else{
			System.out.println(number+" is not an Abundant number");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}