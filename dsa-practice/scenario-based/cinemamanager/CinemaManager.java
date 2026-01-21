package cinemamanager;

import java.util.ArrayList;
import java.util.List;

public class CinemaManager {

    private List<String> titles = new ArrayList<>();
    private List<String> times = new ArrayList<>();

    // Add movie
    public void addMovie(String title, String time) throws InvalidTimeFormatException {

        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }

        titles.add(title);
        times.add(time);

        System.out.println("Movie added: " + title + " at " + time);
    }

    // Search movie 
    public void searchMovie(String keyword) {

        boolean found = false;

        for (int i = 0; i < titles.size(); i++) {

            if (titles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + titles.get(i) + " at " + times.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movie found with keyword: " + keyword);
        }
    }

    // Display all movies
    public void displayAllMovies() {

        if (titles.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        System.out.println("\nMovie Schedule:");

        for (int i = 0; i < titles.size(); i++) {
            System.out.println(String.format("%d. %s - %s", i, titles.get(i), times.get(i)));
        }
    }

    // Convert list to array for report
    public void generateReport() {

        String[] movieArray = titles.toArray(new String[0]);

        System.out.println("\nPrintable Report (Titles Only):");

        for (int i = 0; i < movieArray.length; i++) {
            System.out.println(movieArray[i]);
        }
    }

    // time format HH:MM
    private boolean isValidTime(String time) {

        try {
            String[] parts = time.split(":");

            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;

        } catch (Exception e) {
            return false;
        }
    }

    // IndexOutOfBoundsException handling
    public void showMovieByIndex(int index) {

        try {
            System.out.println("Movie: " + titles.get(index) + " at " + times.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + index);
        }
    }
}
