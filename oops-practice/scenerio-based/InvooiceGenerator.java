package scenrioBase;

public class InvooiceGenerator {
	
	//method to extract task name and amounts
	public static String[][] ParseInvoice(String input){
		String[][] tasks  = new String[2][2];
		
		String[] values = input.trim().split(",");
		
		int index =0;
		
		for(String task : values) {
			String[] taskname= task.split("-");
			tasks[0][index] = taskname[0];
			
			String[] amount = taskname[1].trim().split(" ");
			tasks[1][index] = amount[0];
			index++;
		}
 		
		return tasks;
	}
	
	//method to get total amount
	public static int getTotalAmount(String[] amounts) {
		int total = 0;
		
		for(String amount : amounts) {
			total += Integer.parseInt(amount);
		}
		return total;
	}
 
	public static void main(String[] args) {
		String input = "Logo Design - 3000 INR,Web Page - 4500 INR";
		
		String[][] tasks = ParseInvoice(input);
		
		System.out.println( getTotalAmount(tasks[1]));
		
	}
}