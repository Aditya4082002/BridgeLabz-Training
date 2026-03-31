//program to manage election booth
import java.util.Scanner;

class ElectionBoothManager{
	public static void main(String[] args){
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//candidate vote counter
		int candidate1 = 0;
		int candidate2 = 0;
		int candidate3 = 0;
		
		while(true){
			
			//take age input
			System.out.println("Enter Age or -1 to exit");
			int age = input.nextInt();
			
			//check for exit 
			if(age==-1){
				System.out.println("Thank you for voting");
				break;
			}
			
			//validate and vote
			if(age>=18){
				//ask for vote
				System.out.println("Select Candidate to vite : \n 1 for Candidate1 \n 2 for candidate2 \n 3 for candidate3 ");
				int vote = input.nextInt();
				switch(vote){
					case 1:
						candidate1++;
						break;
					case 2:
						candidate2++;
						break;
					case 3:
						candidate3++;
						break;
					default:
						System.out.println("invalid candidate.");
				}
			}
			else{
				System.out.println(" Age not eligible to vote(must be 18 or above).");
			}
		}
		
		if(candidate1>candidate2 && candidate1>candidate3){
			System.out.println("Winner of election is Candidate1.");
		}
		else if(candidate2>candidate1 && candidate2>candidate3){
			System.out.println("Winner of election is Candidate2.");
		}
		else{
			System.out.println("Winner of election is Candidate3.");	
		}
		
		//close scanner stream
		input.close();
	}
}