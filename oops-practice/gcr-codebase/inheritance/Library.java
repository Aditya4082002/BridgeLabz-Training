package inheritance;

//class definition of Book class
class Book{
	//attributes
	protected String title;
	protected int publicationYear;
	
	//constructor
	Book(String title,int publicationYear){
		this.title = title;
		this.publicationYear = publicationYear;
	}
}

//class definition of Author sub class
class Author extends Book{
	//attributes
	protected String name;
	protected String bio;
	
	//constructor
	Author(String title,int publicationYear, String name,String bio){
		//calling constructor of super class
		super(title,publicationYear);
		
		this.name = name;
		this.bio = bio;
	}
	
	//method to display details of book and author
	public void displayInfo() {
		System.out.println("Title of Book : " + title);
		System.out.println("publication year : " + publicationYear);
		System.out.println("Author name : " + name);
		System.out.println("Bio : " + bio);
	}
}

public class Library {
	//main method
	public static void main(String[] args) {
		
		//creating object of author class
		Author author1 = new Author("2State",1996,"Chetan Bhagat","writer");
		
		author1.displayInfo();
		
	}

}