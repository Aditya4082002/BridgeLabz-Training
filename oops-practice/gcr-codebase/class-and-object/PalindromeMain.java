package classanobject;

public class PalindromeMain {

	public static void main(String[] args) {
		//create object of palindromechecker
		PalindromeChecker text1 = new PalindromeChecker("A man a plan a canal panama");
		PalindromeChecker text2 = new PalindromeChecker("hello");
		boolean result = text1.checkPalindrome();
		text1.displayResult(result);
		
		result = text2.checkPalindrome();
		text2.displayResult(result);
	}

}
//class definition
class PalindromeChecker{
	//attributes
	private String text;
	
	//constructor
	public PalindromeChecker(String text) {
		this.text = text;
	}
	
	//method to checkPalindrome
	public boolean checkPalindrome() {
		String textWithoutSpace = text.replaceAll(" ","").toLowerCase();
		String reverse="";
		for(int i=textWithoutSpace.length()-1;i>=0;i--) {
			reverse += textWithoutSpace.charAt(i);
		}
		if(reverse.equals(textWithoutSpace)) {
			return true;
		}
		return false;
	}
	
	//method to displayDetails
	public void displayResult(boolean result) {
		if(result) {
			System.out.println(text + " is palindrome");
		}else {
			System.out.println(text + " is not palindrome");
		}
	}
}
