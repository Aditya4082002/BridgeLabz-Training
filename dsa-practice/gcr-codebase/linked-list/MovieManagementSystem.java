package linkedList;

// Node class
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

// Doubly Linked List
class MovieList {
    MovieNode head;
    MovieNode tail;

    // insert at beginning
    public void insertAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // insert at end
    public void insertAtLast(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // insert at specific position (1-based index)
    public void insertAtPosition(String title, String director, int year, double rating, int position) {
        if (position == 1) {
            insertAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            insertAtLast(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // delete movie by title
    public void deleteMovie(String title) {
        if (head == null) {
            System.out.println("No movie records available.");
            return;
        }

        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
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

        System.out.println("Movie deleted successfully.");
    }

    // search by director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found for director: " + director);
        }
    }

    // search by rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found with rating: " + rating);
        }
    }

    // update rating by title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
        } else {
            temp.rating = newRating;
            System.out.println("Rating updated successfully.");
        }
    }

    // display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movie records available.");
            return;
        }

        MovieNode temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movie records available.");
            return;
        }

        MovieNode temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // helper method
    private void displayMovie(MovieNode movie) {
        System.out.println("Title : " + movie.title);
        System.out.println("Director : " + movie.director);
        System.out.println("Year : " + movie.year);
        System.out.println("Rating : " + movie.rating);
        System.out.println("-----------------------");
    }
}

// Main class
public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList movies = new MovieList();

        movies.insertAtBeginning("Inception", "Nolan", 2010, 8.8);
        movies.insertAtLast("Interstellar", "Nolan", 2014, 8.6);
        movies.insertAtLast("Avatar", "Cameron", 2009, 7.8);
        movies.insertAtPosition("Titanic", "Cameron", 1997, 7.9, 2);

        movies.updateRating("Avatar", 8.0);
        movies.deleteMovie("Titanic");

        System.out.println("Search by Director:");
        movies.searchByDirector("Nolan");

        System.out.println("\nMovies Forward:");
        movies.displayForward();

        System.out.println("\nMovies Reverse:");
        movies.displayReverse();
    }
}
