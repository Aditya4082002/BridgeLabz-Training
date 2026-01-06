package scenrioBase;
import java.util.Scanner;

public class SentenceFormater {

    public static String format(String paragraph) {

        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);

            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;

                if (i + 1 < paragraph.length() && paragraph.charAt(i + 1) != ' ') {
                    result.append(' ');
                }
            }
        }

        return result.toString().trim();
    }

	public static void main(String[] args) {
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//take a string input
		System.out.println("");
		String text = input.nextLine();
		
		String formattedString = format(text);
		
		//display formatted String
		System.out.println("Formatted String : " + formattedString);
		
		//close scanner stream
		input.close();
	}

}
