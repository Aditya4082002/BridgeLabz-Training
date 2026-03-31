//program to find substring from a string using char at and
import java.util.Scanner;

class SubStringUsingCharAt{
	public static void main(String[] args){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		//take input for string and start and end index
		System.out.print("Enter String : ");
		String mainString = input.next();
		System.out.print("Enter start index : ");
		int startIndex = input.nextInt();
		System.out.print("Enter end index : ");
		int endIndex = input.nextInt();
		
		//generate subString using char at and subString method
		String subStringUsingChatAt = GenerateSubStringUsingCharAt(mainString,startIndex,endIndex);
		String subStringUsingMethod = mainString.substring(startIndex,endIndex);
		
		//method call to compare substrings
		System.out.println("Substring using charAt : " + subStringUsingChatAt);
		System.out.println("Substring using method : " + subStringUsingMethod);
		if(compareStrings(subStringUsingChatAt,subStringUsingMethod)){
			System.out.println("subStrings are qual.");
		}
		else{
			System.out.println("subStrings are not equal.");
		}
		
		//close scanner stream
		input.close();
	}
	
	//method to generate substring using charAt
	public static String GenerateSubStringUsingCharAt(String string1 , int startIndex , int endIndex){
		String subString  = "";
		for(int index=startIndex;index<endIndex;index++){
			subString = subString+ string1.charAt(index);
		}
		return subString;
	}
	
	//method to compare Strings
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