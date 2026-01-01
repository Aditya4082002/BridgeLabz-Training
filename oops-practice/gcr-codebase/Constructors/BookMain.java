package javaConstructors;

public class BookMain {

	public static void main(String[] args) {
		Book book1 = new Book("2States","Chetan Bhagat",500);
		Book book2 = new Book();
		
		book1.displayDetails();
		book2.displayDetails();

	}

}

//class definition
class Book{
	//attributes
	private String title;
	private String author;
	private double price;
	
	//default constructor
	public Book() {
		title = "Unknown";
		author = "Unknown";
		price = 0;
	}
	
	
	//parameterized constructor
	public Book(String title, String author,double price) {
		this.title= title;
		this.author = author;
		this.price = price;
	}
	
	//method to displayDetails
	public void displayDetails() {
		System.out.println("Title of the book : " + title);
		System.out.println("Author of the book : " + author);
		System.out.println("Price of the book : " + price);
	}
}