package linkedList;

// Node class
class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }
}

// Doubly Linked List
class Library {
    BookNode head;
    BookNode tail;

    // add at beginning
    public void addAtBeginning(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // add at end
    public void addAtLast(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // add at specific position (1-based)
    public void addAtPosition(int id, String title, String author, String genre, boolean status, int position) {
        if (position == 1) {
            addAtBeginning(id, title, author, genre, status);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtLast(id, title, author, genre, status);
            return;
        }

        BookNode newNode = new BookNode(id, title, author, genre, status);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // remove book by ID
    public void removeBook(int id) {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }

        BookNode temp = head;
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
            else
                tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed successfully.");
    }

    // search by title
    public void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found with title: " + title);
        }
    }

    // search by author
    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    // update availability status
    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;

        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
        } else {
            temp.isAvailable = status;
            System.out.println("Availability updated successfully.");
        }
    }

    // display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }

        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }

        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // count books
    public void countBooks() {
        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total number of books: " + count);
    }

    // helper method
    private void displayBook(BookNode book) {
        System.out.println("Book ID : " + book.bookId);
        System.out.println("Title : " + book.title);
        System.out.println("Author : " + book.author);
        System.out.println("Genre : " + book.genre);
        System.out.println("Available : " + (book.isAvailable ? "Yes" : "No"));
        System.out.println("-----------------------");
    }
}

// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();

        library.addAtBeginning(1, "Java Basics", "James", "Programming", true);
        library.addAtLast(2, "Clean Code", "Robert Martin", "Software", true);
        library.addAtLast(3, "Algorithms", "CLRS", "CS", false);
        library.addAtPosition(4, "Python Guide", "Guido", "Programming", true, 2);

        library.updateAvailability(3, true);

        System.out.println("Search by Title:");
        library.searchByTitle("Clean Code");

        System.out.println("\nSearch by Author:");
        library.searchByAuthor("James");

        System.out.println("\nBooks Forward:");
        library.displayForward();

        System.out.println("\nBooks Reverse:");
        library.displayReverse();

        library.countBooks();

        library.removeBook(2);

        System.out.println("\nAfter Deletion:");
        library.displayForward();
    }
}
