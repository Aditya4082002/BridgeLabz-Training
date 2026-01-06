package oopsPillars;

// interface
interface Reservable {

    void reserveItem(String borrowerName);

    boolean checkAvailability();
}

// abstract class
abstract class LibraryItem {

    private int itemId;
    private String title;
    private String author;
    private boolean available = true;
    private String borrowerName;

    public abstract int getLoanDuration();

    public void setDetails(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public void setBorrower(String borrowerName) {
        this.borrowerName = borrowerName;
        this.available = false;
    }

    public void returnItem() {
        this.borrowerName = null;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getItemDetails() {
        return "Item Id: " + itemId +", Title: " + title +", Author: " + author +", Available: " + available;
    }
}

// Book subclass
class Book extends LibraryItem implements Reservable {

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

// main class
public class LibraryManagementSystem {

    public static void processItems(LibraryItem[] items) {

        for (LibraryItem item : items) {

            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                System.out.println("Available: " +
                    ((Reservable) item).checkAvailability());
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        LibraryItem item1 = new Book();
        LibraryItem item2 = new Magazine();
        LibraryItem item3 = new DVD();

        item1.setDetails(101, "Java Programming", "James Gosling");
        item2.setDetails(201, "Tech Monthly", "Editorial Board");
        item3.setDetails(301, "Inception", "Christopher Nolan");

        ((Reservable) item1).reserveItem("Aditya");
        ((Reservable) item3).reserveItem("Rahul");

        LibraryItem[] items = { item1, item2, item3 };

        processItems(items);
    }
}
