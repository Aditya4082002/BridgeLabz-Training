//import Scanner class to take input from user
import java.util.Scanner;

//create a class MeanHeight to find the mean height of players present in a football team
class MeanHeight{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//create array to store height of players and a mean varia
		double[] height = new double[11];
		double sum=0;
		double mean;
		
		//take input for height
		System.out.println("Enter height of players :");
		for(int index=0;index<height.length;index++){
			height[index] = input.nextInt();
		}
		
		//sum of all heights
		for(int index=0;index<height.length;index++){
			sum=sum+height[index];
		}
		
		//calculate mean
		mean = sum/11;
		
		//display the results
		System.out.println("Mean height of all players is : "+ mean);
		
		//Closing the Scanner Stream
		input.close();
	}
}