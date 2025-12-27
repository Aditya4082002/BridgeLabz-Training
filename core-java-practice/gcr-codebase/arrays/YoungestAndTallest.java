//program to find the youngest among the three friends and the tallest using array
import java.util.Scanner;

class YoungestAndTallest{
	public static void main(String[] args){
		//create a scanner object
		Scanner input = new Scanner(System.in);
		
		//create friends array to store names
		String[] friends = {"Amar","Akbar","Anthony"};
		
		//array to store ages and heights of 3 friends
		int[] ages = new int[3];
		int[] heights = new int[3];
		
		int youngest = 0;
		int tallest = 0;
		
		//input for ages and heights
		for(int i=0;i<3;i++){
			System.out.println("Enter details for " + friends[i]);
			
			System.out.println("Enter age : ");
			ages[i] = input.nextInt();
			
			System.out.println("Enter height : ");
			heights[i] = input.nextInt();
		}
		
		//find tallest and youngest
		for(int i=0;i<3;i++){
			if(ages[i]<ages[youngest]){
				youngest=i;
			}
			if(heights[i]<heights[tallest]){
				tallest=i;
			}
		}
		
		//display the results
		System.out.println("Youngest friends : " + friends[youngest]);
		System.out.println("Tallest friends : " + friends[tallest]);
		
		
		//close scanner stream
		input.close();
	}
}