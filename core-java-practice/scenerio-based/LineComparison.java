import java.util.Scanner;
class LineComparison{
	public static void main(String[] args){
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//Start
		System.out.println("Welcome to Line Comparison Computation Program");
		//User input for Co-ordinates of both lines
		System.out.println("Enter x1 Co-ordinate of point A : ");
		int x1 = input.nextInt();
		System.out.println("Enter y1 Co-ordinate of point A : ");
		int y1 = input.nextInt();
		System.out.println("Enter x2 Co-ordinate of point B : ");
		int x2 = input.nextInt();
		System.out.println("Enter y2 Co-ordinate of point B : ");
		int y2 = input.nextInt();
		
		System.out.println("Enter x3 Co-ordinate of point c : ");
		int x3 = input.nextInt();
		System.out.println("Enter y3 Co-ordinate of point c : ");
		int y3 = input.nextInt();
		System.out.println("Enter x4 Co-ordinate of point D : ");
		int x4 = input.nextInt();
		System.out.println("Enter y4 Co-ordinate of point D : ");
		int y4 = input.nextInt();
		
		//calculate length of both lines
		Double lengthOfLineOne = lengthOfLine(x1,y1,x2,y2);
		Double lengthOfLineTwo = lengthOfLine(x3,y3,x4,y4);
		
		//display length of both lines
		System.out.println("Length of the line one is " + lengthOfLineOne);
		System.out.println("Length of the line two is " + lengthOfLineTwo);
		
		//check for equal
		boolean areEqual = compareLines(lengthOfLineOne,lengthOfLineTwo);
		
		if(areEqual){
			System.out.println("Both lines are equal.");
		}else{
			System.out.println("Both lines are not equal.");
		}
		
		
		//close scanner
		input.close();
	}
	//UC 1
	static Double lengthOfLine(int x1,int y1,int x2,int y2){
		double length=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
		return length;
	}
	
	//UC 2
	static boolean compareLines(Double lengthOne, Double lengthTwo){
		if(lengthOne.equals(lengthTwo)){
			return true;
		}
		return false;
	}
}