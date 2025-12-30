package extras;
import java.util.Scanner;

public class CompareStrings {

	public static void main(String[] args) {
		//create scanner object
		Scanner input = new Scanner(System.in);
				
		//take user input
		System.out.print("Enter text 1 : ");
		String textOne = input.nextLine();
		System.out.print("Enter text 2 : ");
		String textTwo = input.nextLine();
		boolean check= false;
		
		for(int i=0,j=0;i<textOne.length() && j<textTwo.length();i++,j++){
			if(textOne.charAt(i) == textTwo.charAt(i)) {
				continue;
			}else if(textOne.charAt(i) < textTwo.charAt(i)){
				System.out.println(textOne +" comes before "+ textTwo +" in lexicographical order");
				check=true;
				break;
			}
			else if(textOne.charAt(i) > textTwo.charAt(i)) {
				System.out.println(textTwo +" comes before "+ textOne +" in lexicographical order");
				check=true;
				break;
			}
		
		} 
		if(!check  && textOne.length()==textTwo.length()) {
			System.out.println("Both word are same.");
		}
		else if(textOne.length()<textTwo.length()) {
			System.out.println(textOne +" comes before "+ textTwo +" in lexicographical order");
		}
		else {
			System.out.println(textTwo +" comes before "+ textOne +" in lexicographical order");
		}
		
		//close scanner
		input.close();
		
	}

}
