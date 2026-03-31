//program to compare two strings
import java.util.Scanner;

class CompareTwoStrings{
	public static void main(String[] args){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		//take 2 string inputs to compare
		System.out.println("Enter first string : ");
		String string1 = input.next();
		System.out.println("Enter second string : ");
		String string2 = input.next();
		
		//method call to compare
		compareStrings(string1,string2);
		
		//close scanner stream
		input.close();
	}
	//method to compare two strings
	public static void compareStrings(String string1,String string2){
		if(string1.length() != string2.length() ){
			System.out.println("Strings are not equal.");
			return;
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
		boolean compareResultUsingequals = string1.equals(string2);
		
		System.out.println("Result with charAt : " + compareResultUsingChatAt);
		System.out.println("Result with equals method : " + compareResultUsingequals);
	}
}