package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import at.ac.fhcampuswien.fhmdb.database.MovieEntity;
import at.ac.fhcampuswien.fhmdb.database.MovieRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movie implements Comparable<Movie> {
    private String title;
    private String description;
    private List<GENRE> genres; // Die Genre-Liste für den Film
    private String id;
    private int releaseYear;
    private String imgUrl;
    private int lengthInMinutes;
    private List<String> directors;
    private List<String> writers;
    private List<String> mainCast;
    private double rating;



    static List<Movie> movies = new ArrayList<>();

    public Movie(String title, String description, List<GENRE> genres, String id, int releaseYear, String imgUrl, int lengthInMinutes, List<String> directors, List<String> writers, List<String> mainCast, double rating) {
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.id = id;
        this.releaseYear = releaseYear;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.directors = directors;
        this.writers = writers;
        this.mainCast = mainCast;
        this.rating = rating;
    }

    // Getter and setter methods, respectively


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<GENRE> getGenre() {
        return genres;
    }

    public void setGenre(List<GENRE> genres) {
        this.genres = genres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getMainCast() {
        return mainCast;
    }

    public void setMainCast(List<String> mainCast) {
        this.mainCast = mainCast;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public static void setMovies(List<Movie> movies) {
        Movie.movies = movies;
    }


    public static List<Movie> initializeMovies() {
        try {
            // call movies without any criteria
            List<MovieEntity> movieEntityList = MovieEntity.fromMovies(MovieAPI.fetchMovies(null, null, null, null));

            MovieRepository movieRepository = new MovieRepository();
            movieRepository.deleteAll(movieEntityList);
            movieRepository.addAll(movieEntityList);

            return MovieEntity.toMovie(movieRepository.getAll());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Movie movie) {
        for (int i = 0; i < movie.getTitle().length(); i++) {
            if (this.getTitle().toUpperCase().charAt(i) < movie.getTitle().toUpperCase().charAt(i)) return - 1;
            if (this.getTitle().toUpperCase().charAt(i) > movie.getTitle().toUpperCase().charAt(i)) return 1;
        }
        return 0;
    }


}