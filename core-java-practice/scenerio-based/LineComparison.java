import java.util.Scanner;
class LineComparison{
	public static void main(String[] args){
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//Start
		System.out.println("Welcome to Line Comparison Computation Program");
		
		//UC 1
		System.out.println("Enter x1 Co-ordinate of point A : ");
		int x1 = input.nextInt();
		System.out.println("Enter y1 Co-ordinate of point A : ");
		int y1 = input.nextInt();
		System.out.println("Enter x2 Co-ordinate of point B : ");
		int x2 = input.nextInt();
		System.out.println("Enter y2 Co-ordinate of point B : ");
		int y2 = input.nextInt();
		
		double length = lengthOfLine(x1,y1,x2,y2);
		
		System.out.println("Length of the line is " + length);
		
		
		//close scanner
		input.close();
	}
	static double lengthOfLine(int x1,int y1,int x2,int y2){
		double length=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
		return length;
	}
}