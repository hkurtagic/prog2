package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
    public void getMostPopularActorTest() {
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
    public void getMoviesBetweenYearsTest() {
        List<Movie> allMovies = new ArrayList<>();
        List<Movie> actual = new ArrayList<>();
        List<Movie> expected = new ArrayList<>(List.of(
                new Movie("test", "test", List.of(GENRE.WAR), "1", 1980, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9),
                new Movie("test", "test", List.of(GENRE.WAR), "1", 1940, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), 9)));

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
}