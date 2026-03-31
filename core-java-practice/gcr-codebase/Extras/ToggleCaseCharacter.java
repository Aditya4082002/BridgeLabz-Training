package extras;
import java.util.Scanner;

public class ToggleCaseCharacter {

	public static void main(String[] args) {
		
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//take user input
		System.out.print("Enter text : ");
		String text = input.nextLine();
		
		String toggleCaseString = "";
		
		for(int i=0;i<text.length();i++) {
			char character = text.charAt(i);
			if(character >= 'a' && character<='z') {
				toggleCaseString += (char)(character-32);
			}
			else if(character >='A' && character <= 'Z') {
				toggleCaseString += (char)(character+32);
			}
			else {
				toggleCaseString += character;
			}
		}
		
		//Display the string after toggle.
		System.out.println("String toggle case : " + toggleCaseString);
		
		//close scanner
		input.close();
		
	}

}
