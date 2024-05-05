package at.ac.fhcampuswien.fhmdb.utils;

import at.ac.fhcampuswien.fhmdb.controllers.HomeViewController;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieUtils extends ArrayList<Movie> {
    private List<Movie> allMovies;

    public MovieUtils(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public MovieUtils filterRating(double rating) {
        if (rating != 0) {
            allMovies = allMovies.stream().filter((Movie m) -> m.getRating() == rating).toList();
        }
        return this;
    }

    public MovieUtils filterYear(int year) {
        if (year != 0) {
            allMovies = allMovies.stream().filter((Movie m) -> m.getReleaseYear() == year).toList();
        }
        return this;
    }

    public MovieUtils filterGenre(String genre) {
        if (genre != null) {
            allMovies = allMovies.stream().filter((Movie m) -> m.getGenre().stream().map(Enum::toString).toList().contains(genre)).toList();
        }

        return this;
    }

    public MovieUtils search(String searchQuery) {    // allMovies is the Movie base which will be searched through
        if (!searchQuery.isBlank())
            allMovies = allMovies.stream().filter(
                    (Movie m) -> m.getTitle().toLowerCase().contains(searchQuery.toLowerCase())
                                 || m.getDescription().toLowerCase().contains(searchQuery.toLowerCase())
            ).toList();

            // terminal output of search results
        System.out.println("\nSearch-Results\n");
        for (Movie movie : allMovies) {
            System.out.println(movie.getTitle() + ' ' + movie.getReleaseYear());
        }

        return this;
    }

    public MovieUtils sort(String order) {
        allMovies = HomeViewController.sort(allMovies, order);
        return this;
    }

    public List<Movie> build() {
        return allMovies;
    }
}
