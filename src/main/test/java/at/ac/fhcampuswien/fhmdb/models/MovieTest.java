package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
}
