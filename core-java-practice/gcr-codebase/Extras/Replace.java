package extras;
import java.util.Scanner;
public class Replace {

	public static void main(String[] args) {
		//create scanner object
	      Scanner input = new Scanner(System.in);

	      // Take user input
	      System.out.print("Enter String: ");
	      String text = input.nextLine();
	      System.out.println("Enter word to find : ");
	      String find = input.next();
	      System.out.println("Enter word to replace : ");
	      String replace = input.next();
	      
	      //create array of words
	      String[] words = text.split(" ");
	      String modifiedString="";
	      
	      //find and replace
	      for(int i=0;i<words.length;i++ ) {
	    	  if(words[i].equals(find)) {
	    		  modifiedString += replace+" ";
	    	  }
	    	  else {
	    		  modifiedString += words[i]+" ";
	    	  }
	      }
	      
	      System.out.println("modified String : " + modifiedString);
	      
	      //close scanner stream
	      input.close();
	      
	      
	}

}
