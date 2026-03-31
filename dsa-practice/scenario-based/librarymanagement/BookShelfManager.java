package librarymanagement;

public class BookShelfManager {

    public static void main(String[] args) {

        Library library = new Library();

        // Add books 
        library.addBook("Fiction", "Harry Potter", "J.K. Rowling");
        library.addBook("Science", "A Brief History of Time", "Stephen Hawking");
        library.addBook("Technology", "Clean Code", "Robert Martin");

        // Display catalog
        library.displayCatalog();

        System.out.println();

        // Borrow a book
        library.borrowBook("Fiction", "Harry Potter");

        // Display again
        library.displayCatalog();
    }
}
