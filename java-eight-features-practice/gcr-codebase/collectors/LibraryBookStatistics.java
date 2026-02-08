package collectors;

import java.util.*;
import java.util.stream.*;

public class LibraryBookStatistics {

    static class Book {
        private String title;
        private String genre;
        private int pages;

        public Book(String title, String genre, int pages) {
            this.title = title;
            this.genre = genre;
            this.pages = pages;
        }

        public String getTitle() {
            return title;
        }

        public String getGenre() {
            return genre;
        }

        public int getPages() {
            return pages;
        }
    }

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Book A", "Fiction", 300),
                new Book("Book B", "Fiction", 450),
                new Book("Book C", "Science", 500),
                new Book("Book D", "Science", 350),
                new Book("Book E", "History", 280),
                new Book("Book F", "History", 420)
        );

        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.summarizingInt(Book::getPages)
                ));

        System.out.println("Library Book Statistics by Genre:\n");

        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Maximum Pages: " + stats.getMax());
            System.out.println();
        });
    }
}

