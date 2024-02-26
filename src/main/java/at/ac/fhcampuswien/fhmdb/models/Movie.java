package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private List<GENRE> genres;

    public Movie(String title, String description, List<GENRE> list) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        return movies;
    }
}
