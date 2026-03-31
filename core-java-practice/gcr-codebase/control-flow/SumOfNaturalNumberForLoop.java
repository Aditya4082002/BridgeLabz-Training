//import Scanner class to take input from user
import java.util.Scanner;

class SumOfNaturalNumberForLoop{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		int number=input.nextInt();
		int sum=number*(number+1)/2;
		int sumUsingFor=0;
		for(int i=number;i>0;i--){
			sumUsingFor = sumUsingFor+i;			
		}
		
		//Display the results
		if(sum==sumUsingFor){
			System.out.println("Sum using formula : "+sum+" and sum using for loop "+sumUsingFor+" and they are equal");
		}
		
		
		//Closing the Scanner Stream
		input.close();
	}
}