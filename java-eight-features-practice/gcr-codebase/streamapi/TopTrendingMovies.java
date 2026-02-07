package streamapi;
import java.util.*;
import java.util.stream.*;

class Movie {
    private String title;
    private double rating;
    private int releaseYear;
    private boolean trending;

    public Movie(String title, double rating, int releaseYear, boolean trending) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.trending = trending;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isTrending() {
        return trending;
    }

    @Override
    public String toString() {
        return title + " | Rating: " + rating + " | Year: " + releaseYear;
    }
}


public class TopTrendingMovies {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("Inception", 8.8, 2010, true),
                new Movie("Avengers: Endgame", 8.4, 2019, true),
                new Movie("Interstellar", 8.6, 2014, true),
                new Movie("The Dark Knight", 9.0, 2008, true),
                new Movie("Joker", 8.5, 2019, false),
                new Movie("Oppenheimer", 8.7, 2023, true),
                new Movie("Dune", 8.3, 2021, true),
                new Movie("Avatar: The Way of Water", 7.9, 2022, true),
                new Movie("Tenet", 7.5, 2020, false)
        );

        // Stream pipeline
        List<Movie> top5 = movies.stream()
        		.filter(Movie::isTrending)// 1️ Filter only trending movies
                .sorted(Comparator
                        .comparingDouble(Movie::getRating).reversed()
                        .thenComparing(Movie::getReleaseYear, Comparator.reverseOrder()))// 2️ Sort 
                .limit(5)// 3️ Limit to top 5
                .collect(Collectors.toList());// 4️ Collect into List

        System.out.println("Top 5 Trending Movies:\n");

        top5.forEach(System.out::println);
    }
}
