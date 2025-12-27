//program to convert the complete text to lowercase and compare the results
import java.util.Scanner;

class TextToLowerCase{
	public static void main(String[] args){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		String string1 = input.next();
		String lowercaseString = convertToLowercase(string1);
		String lowercaseStringUsingMethod = string1.toLowerCase();
		
		//compare strings using user defined function
		boolean compareResult = compareStrings(lowercaseString,lowercaseStringUsingMethod);
		if(compareResult){
			System.out.println("Both lowercase strings are equal.");
		}
		else{
			System.out.println("Both lowercase strings are not equal.");	
		}
		
		//close scanner stream
		input.close();
	}
	
	public static String convertToLowercase(String string1){
		String lowercase = "";
		for(int index =0;index<string1.length();index++){
			if(string1.charAt(index)>='A' && string1.charAt(index)<='Z'){
				lowercase = lowercase + (char)(string1.charAt(index)+32);
			}
			else{
				lowercase = lowercase + string1.charAt(index);
			}
		}
		return lowercase;
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