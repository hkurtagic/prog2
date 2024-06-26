package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import at.ac.fhcampuswien.fhmdb.utils.MovieUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void initializeMovies_Method_must_return_a_list_of_Movies() {
        // given
        List<Movie> movies = Movie.initializeMovies();

        // list should not be null, for example if return value wasn't initialized
        assertNotNull(movies, "The return value is null. This should not happen. Maybe the return value is not " +
                "initialized?");

        for (Movie movieElement : movies) {
            assertTrue(movieElement instanceof Movie, "The list which is returned by initializeMovies() does not " +
                    "contain instances of Movie!");
        }
    }

    @Test
    public void sort_list_of_movies_with_unique_items_in_order() {

        //given
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("The Creator", "Inmitten eines künftigen Krieges zwischen der Menschheit und den " +
                "Kräften" + " der künstlichen Intelligenz wird Joshua, ein abgeklärter ehemaliger " +
                "Special-Forces-Agent, der um " + "seine verschwundene Frau trauert, rekrutiert, um den Creator zu " +
                "jagen und zu töten. Der Creator, ein" + " schwer fassbarer Architekt einer fortschrittlichen KI, " +
                "entwickelte eine mysteriöse Waffe, die den " + "Krieg zwar beenden kann, aber gleichzeitig auch die " +
                "Menschheit komplett auslöschen würde. Joshua und" + " sein Team bestehend aus Elite-Agenten, " +
                "durchqueren die feindlichen Linien und dringen in das dunkle" + " Herz des von der KI besetzten " +
                "Territoriums … Nur um herauszufinden, dass die weltverändernde Waffe," + " die er zerstören soll, " +
                "eine KI in Form eines kleinen Kindes ist.", List.of(GENRE.ACTION, GENRE.ADVENTURE,
                GENRE.SCIENCE_FICTION), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("SAW X", "Zwischen den Ereignissen von SAW I und II begibt sich John Kramer nach Mexiko,"
                + " um sich einer experimentellen medizinischen Behandlung zu unterziehen. Die Hoffnung auf eine " +
                "Wunderheilung treibt ihn an. Doch stattdessen entdeckt er, dass die gesamte Operation ein " +
                "teuflischer Betrug ist. Mit einem neuen Ziel vor Augen kehrt der berüchtigte Serienmörder zu seiner "
                + "Arbeit zurück: Er dreht den Spieß um und zieht die Betrüger auf seine ganz eigene, hinterhältige " +
                "und" + " raffinierte Art zur Rechenschaft.", List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("Die Monster AG",
                "In der Monster-AG-Fabrik gehen die Bösewichte eifrig ihrer Arbeit " + "nach: Über Schranktüren " +
                        "schleichen sie sich in Kinderzimmer ein und sammeln die Angstschreie ihrer " + "Bewohner, " +
                        "die den Strom für Monstropolis liefern. Ungekrönter Star unter den einfallsreichen " +
                        "\"Schreckeinjagern\" ist Sully. Dem passiert eines Tages ein folgenschweres Missgeschick: " +
                        "Das kleine" + " Mädchen Boo, dem er wie gewohnt einen kräftigen Schock versetzen will, " +
                        "verkrallt sich in sein Fell." + " Als er dann mit dem Kind in die Fabrik zurückkehrt, bricht" +
                        " das totale Chaos aus...", List.of(GENRE.ANIMATION, GENRE.COMEDY, GENRE.FAMILY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("Universum", "Die international renommierte ORF-Reihe UNIVERSUM bietet zweimal pro " +
                "Woche" + " eindrucksvolle und qualitativ hochwertige Dokumentationen aus aller Welt.",
                List.of(GENRE.DOCUMENTARY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        //when
        movies = new MovieUtils(movies).sort("asc").build();    // TODO: @HARIS KÖNNTEST DU DAS BITTE REVIEWEN?

        //then
        List<Movie> finalMovies = movies;
        assertAll("Check if the list of movies is in the right order",
                () -> assertEquals("Die Monster AG", finalMovies.get(0).getTitle(), "First movie should be \"Die Monster AG\""),
                () -> assertEquals("SAW X", finalMovies.get(1).getTitle(), "Second movie should be \"SAW X\""),
                () -> assertEquals("The Creator", finalMovies.get(2).getTitle(), "Third movie should be \"The Creator\""),
                () -> assertEquals("Universum", finalMovies.get(3).getTitle(), "Fourth movie should be \"Universum\"")
        );
    }

    @Test
    public void sort_list_of_movies_with_unique_items_ascending_in_order() {

        //given
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("The Creator", "Inmitten eines künftigen Krieges zwischen der Menschheit und den " +
                "Kräften" + " der künstlichen Intelligenz wird Joshua, ein abgeklärter ehemaliger " +
                "Special-Forces-Agent, der um " + "seine verschwundene Frau trauert, rekrutiert, um den Creator zu " +
                "jagen und zu töten. Der Creator, ein" + " schwer fassbarer Architekt einer fortschrittlichen KI, " +
                "entwickelte eine mysteriöse Waffe, die den " + "Krieg zwar beenden kann, aber gleichzeitig auch die " +
                "Menschheit komplett auslöschen würde. Joshua und" + " sein Team bestehend aus Elite-Agenten, " +
                "durchqueren die feindlichen Linien und dringen in das dunkle" + " Herz des von der KI besetzten " +
                "Territoriums … Nur um herauszufinden, dass die weltverändernde Waffe," + " die er zerstören soll, " +
                "eine KI in Form eines kleinen Kindes ist.", List.of(GENRE.ACTION, GENRE.ADVENTURE,
                GENRE.SCIENCE_FICTION), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("SAW X", "Zwischen den Ereignissen von SAW I und II begibt sich John Kramer nach Mexiko,"
                + " um sich einer experimentellen medizinischen Behandlung zu unterziehen. Die Hoffnung auf eine " +
                "Wunderheilung treibt ihn an. Doch stattdessen entdeckt er, dass die gesamte Operation ein " +
                "teuflischer Betrug ist. Mit einem neuen Ziel vor Augen kehrt der berüchtigte Serienmörder zu seiner "
                + "Arbeit zurück: Er dreht den Spieß um und zieht die Betrüger auf seine ganz eigene, hinterhältige " +
                "und" + " raffinierte Art zur Rechenschaft.", List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("Die Monster AG",
                "In der Monster-AG-Fabrik gehen die Bösewichte eifrig ihrer Arbeit " + "nach: Über Schranktüren " +
                        "schleichen sie sich in Kinderzimmer ein und sammeln die Angstschreie ihrer " + "Bewohner, " +
                        "die den Strom für Monstropolis liefern. Ungekrönter Star unter den einfallsreichen " +
                        "\"Schreckeinjagern\" ist Sully. Dem passiert eines Tages ein folgenschweres Missgeschick: " +
                        "Das kleine" + " Mädchen Boo, dem er wie gewohnt einen kräftigen Schock versetzen will, " +
                        "verkrallt sich in sein Fell." + " Als er dann mit dem Kind in die Fabrik zurückkehrt, bricht" +
                        " das totale Chaos aus...", List.of(GENRE.ANIMATION, GENRE.COMEDY, GENRE.FAMILY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("Universum", "Die international renommierte ORF-Reihe UNIVERSUM bietet zweimal pro " +
                "Woche" + " eindrucksvolle und qualitativ hochwertige Dokumentationen aus aller Welt.",
                List.of(GENRE.DOCUMENTARY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        //when
        movies = new MovieUtils(movies).sort("asc").build();

        //then
        List<Movie> finalMovies = movies;
        assertAll("Check if the list of movies is in the right order",
                () -> assertEquals("Die Monster AG", finalMovies.get(0).getTitle(), "First movie should be \"Die Monster AG\""),
                () -> assertEquals("SAW X", finalMovies.get(1).getTitle(), "Second movie should be \"SAW X\""),
                () -> assertEquals("The Creator", finalMovies.get(2).getTitle(), "Third movie should be \"The Creator\""),
                () -> assertEquals("Universum", finalMovies.get(3).getTitle(), "Fourth movie should be \"Universum\"")
        );
    }

    @Test
    public void sort_list_of_movies_with_unique_items_in_descending_order() {

        //given
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("The Creator", "Inmitten eines künftigen Krieges zwischen der Menschheit und den " +
                "Kräften" + " der künstlichen Intelligenz wird Joshua, ein abgeklärter ehemaliger " +
                "Special-Forces-Agent, der um " + "seine verschwundene Frau trauert, rekrutiert, um den Creator zu " +
                "jagen und zu töten. Der Creator, ein" + " schwer fassbarer Architekt einer fortschrittlichen KI, " +
                "entwickelte eine mysteriöse Waffe, die den " + "Krieg zwar beenden kann, aber gleichzeitig auch die " +
                "Menschheit komplett auslöschen würde. Joshua und" + " sein Team bestehend aus Elite-Agenten, " +
                "durchqueren die feindlichen Linien und dringen in das dunkle" + " Herz des von der KI besetzten " +
                "Territoriums … Nur um herauszufinden, dass die weltverändernde Waffe," + " die er zerstören soll, " +
                "eine KI in Form eines kleinen Kindes ist.", List.of(GENRE.ACTION, GENRE.ADVENTURE,
                GENRE.SCIENCE_FICTION), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("SAW X", "Zwischen den Ereignissen von SAW I und II begibt sich John Kramer nach Mexiko,"
                + " um sich einer experimentellen medizinischen Behandlung zu unterziehen. Die Hoffnung auf eine " +
                "Wunderheilung treibt ihn an. Doch stattdessen entdeckt er, dass die gesamte Operation ein " +
                "teuflischer Betrug ist. Mit einem neuen Ziel vor Augen kehrt der berüchtigte Serienmörder zu seiner "
                + "Arbeit zurück: Er dreht den Spieß um und zieht die Betrüger auf seine ganz eigene, hinterhältige " +
                "und" + " raffinierte Art zur Rechenschaft.", List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("Die Monster AG",
                "In der Monster-AG-Fabrik gehen die Bösewichte eifrig ihrer Arbeit " + "nach: Über Schranktüren " +
                        "schleichen sie sich in Kinderzimmer ein und sammeln die Angstschreie ihrer " + "Bewohner, " +
                        "die den Strom für Monstropolis liefern. Ungekrönter Star unter den einfallsreichen " +
                        "\"Schreckeinjagern\" ist Sully. Dem passiert eines Tages ein folgenschweres Missgeschick: " +
                        "Das kleine" + " Mädchen Boo, dem er wie gewohnt einen kräftigen Schock versetzen will, " +
                        "verkrallt sich in sein Fell." + " Als er dann mit dem Kind in die Fabrik zurückkehrt, bricht" +
                        " das totale Chaos aus...", List.of(GENRE.ANIMATION, GENRE.COMEDY, GENRE.FAMILY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movies.add(new Movie("Universum", "Die international renommierte ORF-Reihe UNIVERSUM bietet zweimal pro " +
                "Woche" + " eindrucksvolle und qualitativ hochwertige Dokumentationen aus aller Welt.",
                List.of(GENRE.DOCUMENTARY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        //when
        movies = new MovieUtils(movies).sort("des").build();
        //then
        List<Movie> finalMovies = movies;
        assertAll("Check if the list of movies is in the right order",
                () -> assertEquals("Universum", finalMovies.get(0).getTitle(), "Firstmovie should be \"Universum\""),
                () -> assertEquals("The Creator", finalMovies.get(1).getTitle(), "Second movie should be \"The Creator\""),
                () -> assertEquals("SAW X", finalMovies.get(2).getTitle(), "Third movie should be \"SAW X\""),
                () -> assertEquals("Die Monster AG", finalMovies.get(3).getTitle(), "Fourth  movie should be \"Die Monster AG\"")
        );
    }


    /*
     * * * * * * * *  SEARCH FILTER   * * * * * * * * *
     */
    @Test
    public void an_empty_search_query_has_to_show_all_movies() {
        //given
        String searchQuery = "";
        List<Movie> expected = new ArrayList<>();
        List<Movie> actual;

        expected.add(new Movie("The Creator", "Inmitten eines künftigen Krieges zwischen der Menschheit und den " +
                "Kräften" + " der künstlichen Intelligenz wird Joshua, ein abgeklärter ehemaliger " +
                "Special-Forces-Agent, der um " + "seine verschwundene Frau trauert, rekrutiert, um den Creator zu " +
                "jagen und zu töten. Der Creator, ein" + " schwer fassbarer Architekt einer fortschrittlichen KI, " +
                "entwickelte eine mysteriöse Waffe, die den " + "Krieg zwar beenden kann, aber gleichzeitig auch die " +
                "Menschheit komplett auslöschen würde. Joshua und" + " sein Team bestehend aus Elite-Agenten, " +
                "durchqueren die feindlichen Linien und dringen in das dunkle" + " Herz des von der KI besetzten " +
                "Territoriums … Nur um herauszufinden, dass die weltverändernde Waffe," + " die er zerstören soll, " +
                "eine KI in Form eines kleinen Kindes ist.", List.of(GENRE.ACTION, GENRE.ADVENTURE,
                GENRE.SCIENCE_FICTION), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        expected.add(new Movie("SAW X", "Zwischen den Ereignissen von SAW I und II begibt sich John Kramer nach Mexiko,"
                + " um sich einer experimentellen medizinischen Behandlung zu unterziehen. Die Hoffnung auf eine " +
                "Wunderheilung treibt ihn an. Doch stattdessen entdeckt er, dass die gesamte Operation ein " +
                "teuflischer Betrug ist. Mit einem neuen Ziel vor Augen kehrt der berüchtigte Serienmörder zu seiner "
                + "Arbeit zurück: Er dreht den Spieß um und zieht die Betrüger auf seine ganz eigene, hinterhältige " +
                "und" + " raffinierte Art zur Rechenschaft.", List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        expected.add(new Movie("Die Monster AG",
                "In der Monster-AG-Fabrik gehen die Bösewichte eifrig ihrer Arbeit " + "nach: Über Schranktüren " +
                        "schleichen sie sich in Kinderzimmer ein und sammeln die Angstschreie ihrer " + "Bewohner, " +
                        "die den Strom für Monstropolis liefern. Ungekrönter Star unter den einfallsreichen " +
                        "\"Schreckeinjagern\" ist Sully. Dem passiert eines Tages ein folgenschweres Missgeschick: " +
                        "Das kleine" + " Mädchen Boo, dem er wie gewohnt einen kräftigen Schock versetzen will, " +
                        "verkrallt sich in sein Fell." + " Als er dann mit dem Kind in die Fabrik zurückkehrt, bricht" +
                        " das totale Chaos aus...", List.of(GENRE.ANIMATION, GENRE.COMEDY, GENRE.FAMILY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        expected.add(new Movie("Universum", "Die international renommierte ORF-Reihe UNIVERSUM bietet zweimal pro " +
                "Woche" + " eindrucksvolle und qualitativ hochwertige Dokumentationen aus aller Welt.",
                List.of(GENRE.DOCUMENTARY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        // when
        actual = new MovieUtils(expected).search("").build();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void a_search_query_with_only_space_characters_has_to_show_all_movies() {
        // given
        String searchQuery = "           ";

        List<Movie> expected = new ArrayList<>();
        List<Movie> actual;

        expected.add(new Movie("This is a movie", "This is a description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        expected.add(new Movie("This is a another movie", "This is another description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        expected.add(new Movie("This is a third movie", "This is a third description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        // when
        actual = new MovieUtils(expected).search("").build();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void uppercase_and_lowercase_letters_lead_to_the_same_results() {
        //given
        List<Movie> expected = new ArrayList<>();
        List<Movie> actualLowercase;
        List<Movie> actualUppercase;

        String lowercaseQuery = "this is";
        String uppercaseQuery = "THIS IS";

        expected.add(new Movie("This is a movie", "This is a description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        expected.add(new Movie("This is a another movie", "This is another description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        expected.add(new Movie("This is a third movie", "This is a third description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        // when
       actualLowercase = new MovieUtils(expected).search(lowercaseQuery).build();
       actualUppercase = new MovieUtils(expected).search(uppercaseQuery).build();

        // then
        assertAll("Check if the list of movies is in the right order",
                () -> assertEquals(expected, actualLowercase),
                () -> assertEquals(expected, actualUppercase)
        );
    }

    @Test
    public void a_search_request_with_no_matches_has_no_result() {
        String searchQuery = "abc";
        List<Movie> expected = new ArrayList<>();
        List<Movie> actual = new ArrayList<>();

        actual.add(new Movie("This is a movie", "This is a description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        actual.add(new Movie("This is a another movie", "This is another description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        actual.add(new Movie("This is a third movie", "This is a third description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        // when
        actual = new MovieUtils(actual).search(searchQuery).build();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void a_matching_query_and_title_lead_to_a_result() {
        // given
        String searchQuery = "this is a movie";
        List<Movie> movieList = new ArrayList<>();
        List<Movie> expected = new ArrayList<>();
        List<Movie> actual = new ArrayList<>();

        movieList.add(new Movie("This is a movie", "This is a description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a another movie", "This is another description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a third movie", "This is a third description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        expected.add(movieList.get(0));

        // when
       actual = new MovieUtils(movieList).search(searchQuery).build();

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void a_matching_query_and_description_lead_to_a_result() {
        // given
        String searchQuery = "this is a description";
        List<Movie> movieList = new ArrayList<>();
        List<Movie> expected = new ArrayList<>();
        List<Movie> actual;

        movieList.add(new Movie("This is a movie", "This is a description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a another movie", "This is another description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a third movie", "This is a third description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        expected.add(movieList.get(0));

        // when
        actual = new MovieUtils(movieList).search(searchQuery).build();

        // then
        assertEquals(expected, actual);
    }



    /*
     * * * * * * * * GENRE FILTER * * * * * * * * * * * * * *
     */

    @Test
    public void no_genre_selected_results_in_all_movies_shown() {
        List<Movie> movieList = new ArrayList<>();
        String searchQuery = "";

        movieList.add(new Movie("This is a movie", "This is a description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is another movie", "This is another description", List.of(GENRE.ANIMATION), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a third movie", "This is a third description", List.of(GENRE.FANTASY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        List<Movie> expected = new ArrayList<>(movieList);

        List<Movie> actual =  new MovieUtils(movieList).filterGenre(null).search(searchQuery).build();

        assertEquals(expected, actual);
    }


    @Test
    public void a_movie_with_matching_genre_and_a_search_query_should_be_displayed() {
        List<Movie> movieList = new ArrayList<>();
        String searchQuery = "This is a movie";

        movieList.add(new Movie("This is a movie", "This is a description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a another movie", "This is another description", List.of(GENRE.ANIMATION), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is also a movie", "This is a third description", List.of(GENRE.FANTASY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        List<Movie> expected = List.of(movieList.get(0));

        List<Movie> actual = new MovieUtils(movieList).filterGenre("ADVENTURE").search(searchQuery).build();

        assertEquals(expected, actual);
    }

    @Test
    public void movie_with_a_matching_genre_and_a_search_query_and_sorted_asc_should_be_displayed_correctly() {
        List<Movie> movieList = new ArrayList<>();
        String searchQuery = "This";

        movieList.add(new Movie("This is a movie", "This is a description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a another movie", "This is another description", List.of(GENRE.ANIMATION), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a third movie", "This is a third description", List.of(GENRE.FANTASY), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));
        movieList.add(new Movie("This is a third movie", "This is a third description", List.of(GENRE.ADVENTURE), "1", 2020, "", 12, new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1", "test2")), new ArrayList<>(List.of(
                "test", "test1")), 9));

        List<Movie> actual = new MovieUtils(movieList).search(searchQuery).filterGenre("ADVENTURE").sort("asc").build();

        List<Movie> expected = List.of(movieList.get(0),movieList.get(3));

        assertEquals(expected, actual);
    }
}