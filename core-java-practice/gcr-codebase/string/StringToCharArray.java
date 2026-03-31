//program to return all the characters in a string using the user-defined method,  compare the result with the String built-in toCharArray() method, and display the result
import java.util.Scanner;

class StringToCharArray{
	public static void main(String[] args){
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		//take input for string
		String mainString = input.next();
		
		//arrays to store characters of the string
		char[] arrayUsingToCharArray = mainString.toCharArray();
		char[] arrayWithoutToCharArray = characters(mainString);
		
		//method call to compare
		boolean compareResult = compareArray(arrayUsingToCharArray,arrayWithoutToCharArray);
		
		//display the results
		if(compareResult){
			System.out.println("Both arrays are equal.");
		}
		else{
			System.out.println("Both arrays are not equal.");	
		}
		
		
		//close scanner stream
		input.close();
	}
	
	//method to return characters in a  string without using toCharArray
	public static char[] characters(String mainString){
		char[] array = new char[mainString.length()];
		
		for(int i=0;i<mainString.length();i++){
			array[i] = mainString.charAt(i);
		}
		return array;
	}
	
	public static boolean compareArray(char[] arrayUsingToCharArray,char[] arrayWithoutToCharArray){
		boolean result=true;
		for(int i=0;i<arrayUsingToCharArray.length;i++){
			if(arrayUsingToCharArray[i] != arrayWithoutToCharArray[i]){
				result = false;
			}
		}
		return result;
	}
	
}