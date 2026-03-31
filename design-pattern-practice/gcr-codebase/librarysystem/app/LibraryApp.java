package librarysystem.app;

import librarysystem.builder.Book;
import librarysystem.factory.User;
import librarysystem.factory.UserFactory;
import librarysystem.singleton.LibraryCatalog;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User student = UserFactory.createUser("student", "Alice");
        User faculty = UserFactory.createUser("faculty", "Dr. Bob");

        student.showRole();
        faculty.showRole();

        catalog.addObserver(student);
        catalog.addObserver(faculty);

        Book book = new Book.BookBuilder("Data Structures by Cormen")
                .author("Thomas H. Cormen")
                .edition("3rd")
                .genre("Computer Science")
                .publisher("MIT Press")
                .build();

        catalog.addBook(book);
    }
}
