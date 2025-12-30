//program to count how many times a given substring occurs in a string.

//import Scanner class to take input from user
import java.util.Scanner;

class SubstringOccurrences{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take user innput
		System.out.println("Enter String : ");
		String text = input.nextLine();
		System.out.println("Enter substring to count : ");
		String subString= input.nextLine();
		int length = subString.length();
		
		int count=0;
		
		for(int i=0;i<text.length()-length;i++){
			String subStringCheck = text.substring(i,(i+length));
			if(subString.equals(subStringCheck)){
				count++;
			}
		}
		
		//Display result
		System.out.println("the subString occurd " + count + "times" );
		
		//Closing the Scanner Stream
		input.close();
	}
}