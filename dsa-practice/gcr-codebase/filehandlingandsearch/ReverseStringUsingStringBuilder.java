package filehandlingandsearch;

public class ReverseStringUsingStringBuilder {

	public static void main(String[] args) {
		String text = "Hello";
		//create a string builder object
		StringBuilder sb = new StringBuilder();
		
		//append string to string builder
		sb.append(text);
		
		//reverse string
		sb.reverse();
		
		//convert string builder to string
		String reversed  = sb.toString();
		
		//print the results
		System.out.println("Original String: " + text);
		System.out.println("Reversed String : " + reversed);

	}
}