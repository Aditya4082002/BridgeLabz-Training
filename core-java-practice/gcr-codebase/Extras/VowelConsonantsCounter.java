//program to count the number of vowels and consonants in a given string.
import java.util.Scanner;

class VowelConsonantsCounter{
	public static void main(String[] args){
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//take String input
		Syetm.out.println("Enter String : ");
		String text = input.nextLine();
		
		//consonants and vowel counter
		int consonants = 0;
		int vowels = 0;
		
		for(int index=0;index<text.length();index++){
			char ch = text.charAt(index);
			if(ch >= 'a' && ch<='z'){
				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
					vowels++;
					continue;
				}
				consonants++;
			}
		}
		
		//Display results
		System.out.println("Number of vowel : " + vowels);
		System.out.println("Number of consonants : " + consonants);
		
		
		//close scanner stream
		input.close();
	}
}