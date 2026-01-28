package scenario;
import java.util.Scanner;

public class FlipKey {

	//method to generate key
	public static String cleanseAndInvert(String input) {
		if(input.length()<6) {
			return "";
		}else if(!input.matches("^[a-zA-Z]+$")) {
			return "";
		}
		StringBuilder key = new StringBuilder();
		input = input.toLowerCase();
		for(int i=0;i<input.length();i++) {
			int ascii = (int)input.charAt(i);
			if(ascii%2!=0) {
				key.append((char)ascii);
			}
		}
		key = key.reverse();
		for(int i=0;i<key.length();i++) {
			if(i%2==0) {
				key.setCharAt(i,(char)(key.charAt(i)-32));
			}
		}
		return key.toString();
	}
	
	public static void main(String[] args) {
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//take user input
		System.out.println("Enter the word : ");
		String word = input.nextLine();
		
		String result = cleanseAndInvert(word);
		if(result.equals("")) {
			System.out.println("Invalid input");
		}else {
			System.out.println("The generated key is -" + result);
		}
		//close scanner stream
		input.close();
	}
}
