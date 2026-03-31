//import Scanner class to take input from user
import java.util.Scanner;

//create class FizzBuzzArray
class FizzBuzzArray{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take a number input
		int number = input.nextInt();
		
		//create a String array
		String[] array = new String[number];
		int index=0;
		
		//check for positive number and fill the array according to conditions
		if(number>0){
			for(int i=1;i<=number;i++){
				if(i%3==0 && i%5==0){
					array[index] = "FizzBuzz";
				}
				else if(i%3==0){
					array[index] = "Fizz";
				}
				else if(i%5==0){
					array[index] = "Buzz";
				}
				else{
					array[index] = Integer.toString(i);
				}
				index++;
			}
			
			//Display the array
			System.out.println("Array : ");
			index=1;
			for(int i=0;i<array.length;i++){
				System.out.println("Position "+ index + " = " +array[i]);
				index++;
			}
		}
		else{
			System.out.println("Number is not Positive.");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}