package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.ListUI;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void check_if_class_movie_exist() throws ClassNotFoundException {
        try {
            Class.forName("at.ac.fhcampuswien.fhmdb.models.Movie");
        } catch (ClassNotFoundException e) {
            fail("The class Movie does not exist: " + e.getMessage());
        }
    }

    @Test
    public void check_if_class_has_all_required_properties() {
        try {
            Field[] fields = Class.forName("at.ac.fhcampuswien.fhmdb.models.Movie").getDeclaredFields();

            List<String> actual = (Arrays.stream(fields).map(Field::getName).toList());

            assertAll("Check if all required properties have been defined",

                    () -> assertTrue(actual.contains("title"), "title is not defined"),
                    () -> assertTrue(actual.contains("description"), "descriptor is not defined"),
                    () -> assertTrue(actual.contains("genres"), "genres is not defined")
            );

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void all_fields_should_have_correct_type() {
        assertAll("Check if the fields of the Movie class all have the correct type",      /* all assertions should be executed even if some of them fail... */
                () -> assertEquals(Movie.class.getDeclaredField("title").getType(), String.class, "Title field is not a String."),

                () -> assertEquals(Movie.class.getDeclaredField("description").getType(), String.class, "Description field is not a String."),

                // check if genre is of type List
                () -> assertEquals(Movie.class.getDeclaredField("genres").getType(), List.class, "Genre field is not a List."
        ));
    }

    @Test
    public void all_elements_of_the_genre_list_should_be_of_type_GENRE() {
        try {
            assertEquals(((ParameterizedType) Movie.class.getDeclaredField("genres").getGenericType()).getActualTypeArguments()[0], GENRE.class, "The genres list does not contain elements of type GENRE.");
            // [0] bc List only expects one generic argument. . .
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void initializeMovies_Method_must_return_a_list_of_Movies() {
        // given
        List<Movie> movies = Movie.initializeMovies();

        // list should not be null, for example if return value wasn't initialized
        assertNotNull(movies, "The return value is null. This should not happen. Maybe the return value is not initialized?");

        for (Movie movieElement : movies) {
            assertTrue(movieElement instanceof Movie, "The list which is returned by initializeMovies() does not contain instances of Movie!");
        }
    }
}