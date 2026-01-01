package javaConstructors;

//Base class
class EBookMain {

 // Access modifiers
 public String ISBN;        // public
 protected String title;    // protected
 private String author;     // private

 // Constructor
 EBookMain(String ISBN, String title, String author) {
     this.ISBN = ISBN;
     this.title = title;
     this.author = author;
 }

 // Setter for author
 public void setAuthor(String author) {
     this.author = author;
 }

 // Getter for author
 public String getAuthor() {
     return author;
 }

 // Display book details
 public void displayBookDetails() {
     System.out.println("ISBN: " + ISBN);
     System.out.println("Title: " + title);
     System.out.println("Author: " + author);
 }
}

//Subclass
public class EBook extends EBookMain {

 String fileFormat;

 EBook(String ISBN, String title, String author, String fileFormat) {
     super(ISBN, title, author);
     this.fileFormat = fileFormat;
 }

 // Demonstrating access to public and protected members
 void displayEBookDetails() {
     System.out.println("ISBN: " + ISBN);        // public access
     System.out.println("Title: " + title);      // protected access
     System.out.println("Author: " + getAuthor()); // private via getter
     System.out.println("File Format: " + fileFormat);
 }

 // Main method
 public static void main(String[] args) {

     EBook ebook = new EBook("978-0134685991", "Effective Java","Joshua Bloch", "PDF");

     ebook.displayBookDetails();
     System.out.println();

     // Modify author using setter
     ebook.setAuthor("J. Bloch");

     ebook.displayEBookDetails();
 }
}