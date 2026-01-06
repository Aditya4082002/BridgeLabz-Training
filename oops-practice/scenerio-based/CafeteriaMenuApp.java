package scenrioBase;
import java.util.Scanner;

public class CafeteriaMenuApp {
	
	//method to display menu
	public static void displayMenu(String[] menu) {
		for(String item : menu) {
			System.out.println("item : " + item);
		}
	}
	
	//method to get item by index
	public static String getItemByIndex(int index,String[] menu) {
		return menu[index];
	}

	public static void main(String[] args) {
		//create object of scanner class
		Scanner input = new Scanner(System.in);
		
		String[] menu = {"milk","bread","pasta","maggie","chai","coffee","momos","paratha","coke","sprite"};
		
		displayMenu(menu);
		
		System.out.println("Enter index to get item : ");
		int index  = input.nextInt();
		
		System.out.println("item at index " + (index+1 )+ " : " + getItemByIndex(index+1,menu));
		
		//close scanner stream
		input.close();
	}

}
