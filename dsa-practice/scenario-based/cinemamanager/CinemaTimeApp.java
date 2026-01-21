package cinemamanager;

public class CinemaTimeApp {

    public static void main(String[] args) {

        CinemaManager manager = new CinemaManager();

        try {
            manager.addMovie("Inception", "18:30");
            manager.addMovie("Interstellar", "21:00");
            manager.addMovie("Avatar", "25:99");   // Will throw exception
        } catch (InvalidTimeFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        manager.displayAllMovies();

        System.out.println();
        manager.searchMovie("inter");

        System.out.println();
        manager.showMovieByIndex(5);  

        System.out.println();
        manager.generateReport();
    }
}
