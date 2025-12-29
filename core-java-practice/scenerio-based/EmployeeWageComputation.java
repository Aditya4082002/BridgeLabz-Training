//program to calculate wage of an employee
import java.util.Scanner;

class EmployeeWageComputation{
	public static void main(String[] args){
		//craete scanner object
		Scanner input = new Scanner(System.in);
		
		final int WAGE_PER_HOUR = 20;
		final int FULL_DAY_HOUR = 8;
		final int PART_TIME_HOUR = 4;
		final int MAX_DAYS = 20;
		final int MAX_HOURS = 100;
		
		
		//Welcome message
		System.out.println("Welcome to Employee Wage Computation Program");
		
		int totalWorkingHours = 0;
		int totalWorkingDays = 0;
		int totalWage = 0;
		//condition for MAX DAYS or MAX HOURS
		while(totalWorkingDays<MAX_DAYS && totalWorkingHours<MAX_HOURS ){
		
			int workingHours =0;
			//UC-1 Check Employee is Present or Absent
			int present = isPresent();
			
			if(present!=0){
				System.out.println("Employee is present.");
				//ask for fulltime or parttime
				System.out.println("Enter your choice 1 for fulltime and 2 for parttime : ");
				int choice = input.nextInt();
				
				if(choice==1){
					workingHours=FULL_DAY_HOUR;
				}
				else{
					workingHours=PART_TIME_HOUR;
				}
				
				totalWorkingHours += workingHours;
				
				int todaysWage = CalculateDailyWage(workingHours,WAGE_PER_HOUR);

				totalWage +=todaysWage;
				System.out.println("Todays wage : " + todaysWage);
				System.out.println("Total Working hours : " + totalWorkingHours);
				
				totalWorkingDays++;
			}else{
				System.out.println("Employee is Absent.");
				
			}
		}
		System.out.println("Total wage : " + totalWage);
		//close scanner 
		input.close();
	}
	
	//UC-1 Check Employee is Present or Absent
	public static int isPresent(){
		int present  = (int)(Math.random() * 2);
		return present;
	}
	
	//UC-2/3 Calculate Daily Employee Wage
	public static int CalculateDailyWage(int workingHours,int wagePerHour){
		return wagePerHour * workingHours;
	}
}