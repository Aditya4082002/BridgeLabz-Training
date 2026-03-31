//create a class PenDistributor to calculate pen per studdent and non-distributed pens
class PenDistributor{
	public static void main(String[] args){
		
		//create variables to indicate number of pens and number of students
		int numberOfPens=14;
		int numberOfStudents=3;
		
		//calculate the pen per student and remaning pens
		int penPerStudent=numberOfPens/numberOfStudents;
		int remaningPens=numberOfPens%numberOfStudents;
		
		//Display the results
		System.out.println("The Pen Per Student is "+ penPerStudent +" and the remaining pen not distributed is "+ remaningPens);
	}
}