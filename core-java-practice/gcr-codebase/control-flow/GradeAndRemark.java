//import Scanner class to take input from user
import java.util.Scanner;

//create a class GradeAndRemark to calculate Grade And Remark
class GradeAndRemark{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take marks as input from user
		int physicsMark = input.nextInt();
		int chemistryMark = input.nextInt();
		int mathMark = input.nextInt();
		
		//calculate average marks and show grade and remarks 
		double percentage = (physicsMark+chemistryMark+mathMark)/3;
		System.out.println("Average marks"+percentage);
		if(percentage>=80){
			System.out.println(" Grade A\n"+"Remarks: Level4, above agency-normalized standards");
		}
		else if(percentage>=70){
			System.out.println(" Grade B\n"+"Remarks: Level3, at agency-normalized standards");
		}
		else if(percentage>=60){
			System.out.println(" Grade C\n"+"Remarks: Level2, below, but approaching agency-normalized standards");
		}
		else if(percentage>=50){
			System.out.println(" Grade D\n"+"Remarks: Level1, well below agency-normalized standards");
		}
		else if(percentage>=40){
			System.out.println(" Grade E\n"+"Remarks: Level1-, too below agency-normalized standards");
		}
		else{
			System.out.println("Grade R\n"+"Remarks: Remedial standards");
		}
		
		
		
		//Closing the Scanner Stream
		input.close();
	}
}