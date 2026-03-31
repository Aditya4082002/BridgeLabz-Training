//program to remove all duplicate characters from a given string

//import Scanner class to take input from user
import java.util.Scanner;

class Duplicates{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take user innput
		System.out.println("Enter String : ");
		String text = input.nextLine();
		
		String modifiedString = "";
		
		for(int i=0;i<text.length();i++){
			boolean isDuplicate = false;
			for(int j=0;j<modifiedString.length();j++){
				if(i != j && text.charAt(i) == modifiedString.charAt(j)){
					isDuplicate = true;
					break;
				}
			}
			if(!isDuplicate){
				modifiedString = modifiedString + text.charAt(i);
			}
		}
		
		//Display result
		System.out.println("String : " + text);
		System.out.println("String with Duplicates removed : " + modifiedString);
		
		//Closing the Scanner Stream
		input.close();
	}
}

 