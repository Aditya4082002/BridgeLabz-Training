//program to convert the complete text to uppercase and compare the results
import java.util.Scanner;

class TextToUpperCase{
	public static void main(String[] args){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		String string1 = input.next();
		String uppercaseString = convertToUppercase(string1);
		String uppercaseStringUsingMethod = string1.toUpperCase();
		
		//compare strings using user defined function
		boolean compareResult = compareStrings(uppercaseString,uppercaseStringUsingMethod);
		if(compareResult){
			System.out.println("Both uppercase strings are equal.");
		}
		else{
			System.out.println("Both uppercase strings are not equal.");	
		}
		
		//close scanner stream
		input.close();
	}
	
	public static String convertToUppercase(String string1){
		String uppercase = "";
		for(int index =0;index<string1.length();index++){
			if(string1.charAt(index)>='a' && string1.charAt(index)<='z'){
				uppercase = uppercase + (char)(string1.charAt(index)-32);
			}
			else{
				uppercase = uppercase + string1.charAt(index);
			}
		}
		return uppercase;
	}
	//method to compare two strings
	public static boolean compareStrings(String string1,String string2){
		if(string1.length() != string2.length() ){
			return false;
		}
		boolean compareResultUsingChatAt = true;
		
		for(int index=0;index<string1.length();index++){
			if(string1.charAt(index) == string2.charAt(index)){
				continue;
			}
			else{
				compareResultUsingChatAt = false;
			}
		}
		return compareResultUsingChatAt;
	}
}