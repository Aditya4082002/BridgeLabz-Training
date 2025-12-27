//program to claculate bonus for 10 emploeys at zara on the basis of their years of service
import java.util.Scanner;

class ZaraBonusCalculator{
	public static void main(String[] args){
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		final int EMP_COUNT=10;
		
		//array to store employee salary,year of service , new salary and bonus amount
		double[] salary = new double[EMP_COUNT];
		double[] yearsOfService = new double[EMP_COUNT];
		double[] bonusAmount = new double[EMP_COUNT];
		double[] newSalary = new double[EMP_COUNT];
		
		//total for company
		double totalBonus = 0;
		double totalOldSalary = 0;
		double totalNewSalary = 0;
		
		//input for salary and year of service
		for(int i=0;i<EMP_COUNT;i++){
			System.out.println("Enter salary of employee "+(i+1)+ " : ");
			System.out.println("Enter salary : ");
			double inputSalary = input.nextDouble();
			System.out.println("Enter years of service : ");
			double inputYearsOfService = input.nextDouble();
			
			//check for valid inputs
			if(inputSalary<=0 || inputYearsOfService <=0){
				System.out.println("Invalid input please enter again");
				i--;
				continue;
			}
			
			salary[i] = inputSalary;
			yearsOfService[i] = inputYearsOfService;
		}
		
		//bonus and total calculations
		for(int i=0;i<EMP_COUNT;i++){
			if(yearsOfService[i]>5){
				bonusAmount[i] = salary[i]*0.05;
			}
			else{
				bonusAmount[i] = salary[i]*0.02;
			}
			
			newSalary[i] = salary[i] + bonusAmount[i];
			
			totalBonus = totalBonus + bonusAmount[i];
			totalOldSalary = totalOldSalary + salary[i];
			totalNewSalary = totalNewSalary + newSalary[i];
			
		}
		
		//display the results
		System.out.println("Total old salary : " + totalOldSalary);
		System.out.println("Total bonus payout : " + totalBonus);
		System.out.println("Total new salary : " + totalNewSalary);
		
		
		//close the scanner stream
		input.close();
	}
}