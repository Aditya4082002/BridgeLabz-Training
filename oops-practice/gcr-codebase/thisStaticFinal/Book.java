package thisStaticFinal;

public class Book {

	//static variable 
	static String libraryName = "Egmore Library"; 
	
	//instance variables
	private String title;
	private String author;
	private final String ISBN; //can not be changed
	
	//static method 
	public static void displayLibraryName() {
		System.out.println("Library Name : "  + libraryName);
	}
	
	//constructor
	public Book(String title,String author, String ISBN){
		this.title = title;
		this.author=author;
		this.ISBN=ISBN;
	}
	
	//method to display details
	public void displayDetails() {
		if(this instanceof Book) {
			System.out.println("Title : " + title);
			System.out.println("Author : " + author);
			System.out.println("ISBN : " + ISBN);
		}else {
			System.out.println("Invalid Object");
		}
	}
	
	//main method 
	public static void main(String[] args) {
		Book book1 = new Book("Efficient java","Joshua Bloch","978-0134685991");
		displayLibraryName();
		book1.displayDetails();
	}

}
