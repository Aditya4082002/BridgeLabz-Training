package scenrioBase;
import java.util.Scanner;

public class LibraryManagementSystem {
	
	//array to store book details
	static String[][] books = new String[3][3];

	
	public static void main(String[] args) {
		//create scanner object
		Scanner input = new Scanner(System.in);
		
 		
		//take user input
		for(int book=0;book<3;book++) {
			System.out.println("Enter details of Book "+(book+1));
			
			System.out.println("Enter Title : ");
			books[book][0] = input.next();
			
			System.out.println("Enter Aauthor : ");
			books[book][1] = input.next();
			
			System.out.println("Enter Status : ");
			books[book][2] = input.next();
			
		}
		displayDetails();

		System.out.println("Enter keyword to search : ");
		String keyword  = input.next();
		searchBook(keyword);
		
		//close Scanner stream
		input.close();

	}
	
	//method to search
	static void searchBook(String keyword) {
		boolean found = false;
		for(String[] book: books) {
			if(book[0].toLowerCase().contains(keyword)) {
				System.out.println("Book found");
				found = true;
				
				System.out.println("Details of book : ");
				System.out.println("Tiitle : " + book[0]);
				System.out.println("Author : " + book[1]);
				System.out.println("Status : "+ book[2]);
			}
		}
		if(!found) {
			System.out.println("Book not found.");
		}
	}
	
	//method to display details of all books
	static void displayDetails() {
		
		for(int book=0;book<3;book++) {
			System.out.println("Details of book : " + (book+1));
			System.out.println("Tiitle : " + books[book][0]);
			System.out.println("Author : " + books[book][1]);
			System.out.println("Status : "+ books[book][2]);
		}
	}	
}
