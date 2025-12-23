//import Scanner class to take input from user
import java.util.Scanner;

class MultiplesBelow100{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number input from user
		int number = input.nextInt();
		
		if(number>0 && number<100){
			for(int i=100;i>0;i--){
				if(i%number==0){
					System.out.println(i+" is multiple of "+ number);
				}
			}
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}
