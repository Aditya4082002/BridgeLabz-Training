//create a class with name AverageMarkCalculator to calculate the average mark
class AverageMarkCalculator{
	public static void main(String[] args){
		
		//create variables for maths, physics, chemistry Mark and assign values
		int mathsMark=94, physicsMark=95, chemistryMark = 96;
		
		//calculate the average percent mark
		int averagePercentMark=(mathsMark+physicsMark+chemistryMark)/3;
		
		//Display the average percent mark
		System.out.println("Sam's average mark in PCM is " + averagePercentMark + "%");
	}
}