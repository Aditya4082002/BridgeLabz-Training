//import Scanner class to take input from user
import java.util.Scanner;

//create a class NumberCheck to input 5 elements in array and check is the number is negative, positive or zero
class NumberCheck{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//create an array number to store 5 numbers
		int[] number = new int[5];
		
		//take input for numbers
		System.out.println("Enter the numbers to check: ");
		for(int index=0;index<number.length;index++){
			number[index] = input.nextInt();
		}
		
		//chcek the numbers for negative,positive or zero
		for(int index=0;index<number.length;index++){
			if(number[index]>0){
				if(number[index]%2==0){
					System.out.println("The number " + number[index] + "is positive and even.");
				}
				else{
					System.out.println("The number " + number[index] + "is positive and odd.");
				}
			}
			else if(number[index]<0){
				System.out.println("The number " + number[index] + "is negative.");
			}
			else{
				System.out.println("The number is zero.");
			}
		}
		
		//comparing first and last elements
		if(number[0]>number[number.length-1]){
			System.out.println(number[0]+" is greater then " + number[number.length-1]);
		}
		else if(number[0]<number[number.length-1]){
			System.out.println(number[0]+" is less then " + number[number.length-1]);
		}
		else{
			System.out.println(number[0]+" is equal to " + number[number.length-1]);
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}