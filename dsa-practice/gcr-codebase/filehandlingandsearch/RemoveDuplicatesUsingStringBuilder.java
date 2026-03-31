package filehandlingandsearch;
import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
	
	public static String removeDuplicates(String str) {
		//create a string builder object
		StringBuilder sb = new StringBuilder();
		//create a hashSet to store character
		HashSet<Character> set = new HashSet<>();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(!set.contains(ch)) {
				sb.append(ch);
				set.add(ch);
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		
		String text = "Programming";
		
		String result = removeDuplicates(text);
		
		System.out.println("Original : " + text);
		System.out.println("Duplicates removed : " + result);

	}
}