package librarymanagement;

import java.util.HashMap;
import java.util.LinkedList;

public class Library {

    // genre -> list of books
    private HashMap<String, LinkedList<Book>> catalog = new HashMap<>();

    // Add book 
    public void addBook(String genre, String title, String author) {

        if (!catalog.containsKey(genre)) {
            catalog.put(genre, new LinkedList<Book>());
        }

        LinkedList<Book> books = catalog.get(genre);
        books.add(new Book(title, author));

        System.out.println(title + " added to " + genre + " section");
    }

    // Borrow book 
    public void borrowBook(String genre, String title) {

        if (!catalog.containsKey(genre)) {
            System.out.println("Genre not found");
            return;
        }

        LinkedList<Book> books = catalog.get(genre);
        boolean found = false;

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                System.out.println(title + " borrowed from " + genre);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found in " + genre);
        }
    }

    // Display catalog 
    public void displayCatalog() {

        if (catalog.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }

        System.out.println("\nLibrary Catalog:");

        for (String genre : catalog.keySet()) {

            System.out.println("\n" + genre + " Books:");
            LinkedList<Book> books = catalog.get(genre);

            for (int i = 0; i < books.size(); i++) {
                System.out.println("  - " + books.get(i));
            }
        }
    }
}
