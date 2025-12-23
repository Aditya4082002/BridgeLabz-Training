//import Scanner class to take input from user
import java.util.Scanner;

class DivisibilityCheck{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take input from user
		int number = input.nextInt();
		String answer;
		
		//check the divisibility
		if(number%5==0){
			answer="Yes";
		}
		else{
			answer="No";
		}
		
		//Display the results
		System.out.println("Is the number : " +number+" divisible by 5? " + answer);
		input.close();
	}
}