package scenario;
import java.util.Scanner;

public class LexicalTwist {
	
	public static String reverse(String text) {
		StringBuilder reverse =new StringBuilder();
		for(int i=text.length()-1;i>=0;i--) {
			reverse.append(text.charAt(i));
		}
		return reverse.toString();
	}
	
	public static boolean isReversed(String first,String second) {
		boolean isreverse = false;
		String reverse = reverse(second).toLowerCase();
		if(reverse.equalsIgnoreCase(first)) {
			isreverse = true;
		}
		return isreverse;
	}
	
	public static String vowelConsonantOperation(String word) {
		char[] result = new char[2];
		
		int vowelCount = 0;
		int consonantCount = 0;
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
				vowelCount++;
			}else {
				consonantCount++;
			}
		}
		if(vowelCount>consonantCount) {
			int index=0;
			for(int i=0;i<word.length()&&index<2;i++) {
				char ch = word.charAt(i);
				if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
					if(index==0 || result[index-1] != ch) {
						result[index++]=ch;
					}
				}
			}
		}else if(vowelCount<consonantCount){
			int index=0;
			for(int i=0;i<word.length()&&index<2;i++) {
				char ch = word.charAt(i);
				if("AEIOU".indexOf(ch)==-1) {
					if(index==0 || result[index-1] != ch) {
						result[index++]=ch;
					}
				}
			}
		}else {
			return "Vowels and Consonants are equal.";
		}
		
		return  new String(result);
	}

	public static void main(String[] args) {
		//create object of scanner
		Scanner input = new Scanner(System.in);
		//take 2 words input
		System.out.println("Enter the first word : ");
		String first = input.nextLine();
		if(first.trim().contains(" ")) {
			System.out.println(first + " is not a vaild input");
			return;
		}
		System.out.println("Enter the second word : ");
		String second = input.nextLine();
		if(second.trim().contains(" ")) {
			System.out.println(second + " is not a vaild input");
			return;
		}
		
		
		if(isReversed(first,second)) {
			String reverseFirst = reverse(first).toLowerCase();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<reverseFirst.length();i++) {
				char ch =reverseFirst.charAt(i);
				if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
					sb.append('@');
				}else {
					sb.append(ch);
				}
			}
			System.out.println(sb.toString());
		}else {
			String combinedWord = (first+second).toUpperCase();
			String result = vowelConsonantOperation(combinedWord);
			System.out.println(result);
		}
		
		
		//close scanner stream
		input.close();
	}
}
