package extras;
import java.util.Scanner;

public class ModifiedString {

	public static void main(String[] args) {
		//create scanner object
		Scanner input = new Scanner(System.in);
						
		//take user input
		System.out.print("Enter String : ");
		String text = input.nextLine();
		System.out.print("Enter the caharacter to remove");
		char character = input.next().charAt(0);
		
		String modifiedString = "";
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i)==character) {
				continue;
			}
			else {
				modifiedString += text.charAt(i);
			}
		}
		
		//display the modifiedString
		System.out.println("Modified String: " + modifiedString);
		
		//close scanner
		input.close();
		
	}

}
