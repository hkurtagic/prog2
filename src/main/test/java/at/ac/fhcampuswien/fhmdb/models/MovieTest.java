package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import org.junit.jupiter.api.Test;

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
    public void check_if_fields_have_correct_type() {
        assertAll("Check if the fields have the correct type",
                () -> assertEquals(Movie.class.getDeclaredField("title").getType(),String.class, "Title is not a String"),

                () -> assertEquals(Movie.class.getDeclaredField("description").getType(),String.class, "Description is not a String"),

                // check if genre is of type List
                () -> assertEquals(Movie.class.getDeclaredField("genres").getType(),List.class, "Genre is not a String"),

                // check if genre is a List of GENRE
                () -> assertEquals(((ParameterizedType) Movie.class.getDeclaredField("genres").getGenericType()).getActualTypeArguments()[0],
                        GENRE.class, "Genre is not a list of GENRRE"
        ));
    }

    @Test
    public void check_if_initializeMovies_Method_has_been_defined() throws NoSuchMethodException {
        assertDoesNotThrow(() -> Movie.class.getDeclaredMethod("initializeMovies"), "Method 'initializeMovies' is not defined.");

    }

    @Test
    public void check_if_initializeMovies_Method_returns_a_list_of_Movies() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        assertEquals(Movie.class.getDeclaredMethod("initializeMovies").invoke(null).getClass().getSuperclass().getInterfaces()[0], List.class, "Method 'initializeMovies' does not return a list of Movies.");
    }

}
