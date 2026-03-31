package librarysystem.singleton;

import java.util.ArrayList;
import java.util.List;

import librarysystem.builder.Book;
import librarysystem.observer.Observer;

public class LibraryCatalog {

    private static LibraryCatalog instance;

    private List<Book> books;
    private List<Observer> observers;

    private LibraryCatalog() {
        books = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addBook(Book book) {
        books.add(book);
        notifyUsers(book.getTitle());
    }

    private void notifyUsers(String title) {
        for (Observer observer : observers) {
            observer.update("New book available: " + title);
        }
    }
}
