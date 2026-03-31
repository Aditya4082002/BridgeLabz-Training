package javaConstructors;

public class Library {

	public static void main(String[] args) {
		//creating object of books class
		Books book1 = new Books("2States","Chetan Bhagat",500,true);
		Books book2 = new Books();
		
		book1.borrowBook();
		book2.borrowBook();
	}

}
//class definition
class Books{
	//attributes
	private String title;
	private String author;
	private double price;
	private boolean availability;
	
	//default constructor
	public Books() {
		title = "Unknown";
		author = "Unknown";
		price = 0;
		availability=false;
	}
	
	
	//parameterized constructor
	public Books(String title, String author,double price,boolean availability) {
		this.title= title;
		this.author = author;
		this.price = price;
		this.availability=availability;
	}
	
	//method to borrow a book
	public void borrowBook() {
		if(this.availability) {
			System.out.println("Borrow successful.");
			availability = false;
		}else {
			System.out.println("Book not available");
		}
	}
}