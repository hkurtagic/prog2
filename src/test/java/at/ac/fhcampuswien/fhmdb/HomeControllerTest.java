package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HomeControllerTest {


    @Test
    public void get_the_most_popular_actor_from_the_allMovies_list() {
        List<Movie> allMovies = new ArrayList<>();
        String actual = "";
        String expected = "test";

        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9));
        actual = HomeController.getMostPopularActor(allMovies);

        assertEquals(expected, actual);
    }

    @Test
    public void get_all_movies_between_two_given_dates() {
        List<Movie> allMovies = new ArrayList<>();
        List<Movie> actual = new ArrayList<>();

        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 1904, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 2024, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 1980, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 1940, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9));
        actual = HomeController.getMoviesBetweenYears(allMovies, 1920, 2000);

        List<Movie> finalActual = actual;
        assertAll("Check if the list of movies correct",
                () -> assertTrue(finalActual.get(0).getReleaseYear() >= 1920 && finalActual.get(0).getReleaseYear() <= 2000),
                () -> assertTrue(finalActual.get(1).getReleaseYear() >= 1920 && finalActual.get(1).getReleaseYear() <= 2000)
        );
    }


    @Test
    public void filter_for_the_longest_title_and_return_the_number_of_letters_of_the_movie() {
        List<Movie> allMovies = new ArrayList<>();
        int actual = 0;
        int expected = 17;

        allMovies.add(new Movie("A very long Movie", "test", List.of(GENRE.WAR), "1", 1904, "", 120, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 2024, "", 5, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 1980, "", 2, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 1940, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9));


        actual = HomeController.getLongestMovieTitle(allMovies);

        assertTrue(actual == expected);
    }

    @Test
    public void return_the_number_of_films_by_a_particular_director_from_a_list_of_movies() {
        List<Movie> allMovies = new ArrayList<>();

        long actual = 1L;
        long expected = 0;

        allMovies.add(new Movie("A very long Movie", "test", List.of(GENRE.WAR), "1", 1904, "", 120, new ArrayList<>(List.of(
                "Max Mustermann", "Hansi")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 2024, "", 5, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 1980, "", 2, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9));
        allMovies.add(new Movie("test", "test", List.of(GENRE.WAR), "1", 1940, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9));


        expected = HomeController.countMoviesFrom(allMovies, "Hansi");

    }

}