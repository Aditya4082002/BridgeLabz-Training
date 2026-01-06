package scenrioBase;
import java.util.Scanner;

class InvalidScoreException extends Exception{
	InvalidScoreException(String message){
		super(message);
	}
}

public class StudentScoreAnalyzer {
	
	public static int calculateAverage(int[] scores) throws InvalidScoreException{
		int total = 0;
		for(int mark : scores) {
			if(mark<0 || mark>100) {
				throw new InvalidScoreException("invalid makrks");
			}
			total += mark;
		}
		
		return total/10;
	}
	
	public static int findMax(int[] scores) throws InvalidScoreException{
		int max=Integer.MIN_VALUE;
		for(int mark :scores) {
			if(mark>max) {
				max=mark;
			}
		}
		return max;
	}
	
	public static int findMin(int[] scores)throws InvalidScoreException{
		int min=Integer.MAX_VALUE;
		for(int mark :scores) {
			if(mark<min) {
				min=mark;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		//create object of scanner class
		Scanner input = new Scanner(System.in);
		
		//take user input
		int[] scores = new int[10];
		System.out.println("Enter Scores.");
		for(int i=0;i<10;i++) {
			scores[i] = input.nextInt();
		}
			
		try {
			System.out.println("Average : " + calculateAverage(scores));
			System.out.println("Max : " + findMax(scores));
			System.out.println("Min : " + findMin(scores));
			
		}catch(InvalidScoreException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		//close scanner object
		input.close();

	}

}
