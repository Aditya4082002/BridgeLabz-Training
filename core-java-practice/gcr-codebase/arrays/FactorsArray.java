//import Scanner class to take input from user
import java.util.Scanner;

//create a class FactorsArray to find factors of a number and store them in a array and display them
class FactorsArray{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take a number form user 
		int number = input.nextInt();
		
		//create a variable maxFactor and an array to store factors
		int maxFactor = 10;
		int[] factors = new int[maxFactor];
		int index =0;
		
		//find the factors and store them in factors array
		for(int i=1;i<=number;i++){
			if(number%i==0){
				if(index==maxFactor){
					maxFactor = maxFactor*2;
					int[] tempArray = new int[maxFactor];
					
					for(int j=0;j<factors.length;j++){
						tempArray[j]=factors[j];
					}
					factors = tempArray;
				}
				factors[index] = i;
				index++;
			}
		}
		
		//display the results store in factors
		System.out.println("Factors of " + number + " are : ");
		for(int i=0;i<index;i++){
			System.out.print(factors[i]+" ");
		}
		
		//Closing the Scanner Stream
		input.close();
	}
}