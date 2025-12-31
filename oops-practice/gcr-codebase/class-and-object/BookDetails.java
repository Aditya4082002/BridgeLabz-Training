package classanobject;

public class BookDetails {

	public static void main(String[] args) {
		Book book1 = new Book("2States","Chetan Bhagat",500);
		Book book2 = new Book("Wings of fire","Abdul kalam A.P.J",500);
		
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
	
	//constructor
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
