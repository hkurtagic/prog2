package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;
import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

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
                GENRE.SCIENCE_FICTION)));
        movies.add(new Movie("SAW X", "Zwischen den Ereignissen von SAW I und II begibt sich John Kramer nach Mexiko,"
                + " um sich einer experimentellen medizinischen Behandlung zu unterziehen. Die Hoffnung auf eine " +
                "Wunderheilung treibt ihn an. Doch stattdessen entdeckt er, dass die gesamte Operation ein " +
                "teuflischer Betrug ist. Mit einem neuen Ziel vor Augen kehrt der berüchtigte Serienmörder zu seiner "
                + "Arbeit zurück: Er dreht den Spieß um und zieht die Betrüger auf seine ganz eigene, hinterhältige " +
                "und" + " raffinierte Art zur Rechenschaft.", List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME)));
        movies.add(new Movie("Die Monster AG",
                "In der Monster-AG-Fabrik gehen die Bösewichte eifrig ihrer Arbeit " + "nach: Über Schranktüren " +
                        "schleichen sie sich in Kinderzimmer ein und sammeln die Angstschreie ihrer " + "Bewohner, " +
                        "die den Strom für Monstropolis liefern. Ungekrönter Star unter den einfallsreichen " +
                        "\"Schreckeinjagern\" ist Sully. Dem passiert eines Tages ein folgenschweres Missgeschick: " +
                        "Das kleine" + " Mädchen Boo, dem er wie gewohnt einen kräftigen Schock versetzen will, " +
                        "verkrallt sich in sein Fell." + " Als er dann mit dem Kind in die Fabrik zurückkehrt, bricht" +
                        " das totale Chaos aus...", List.of(GENRE.ANIMATION, GENRE.COMEDY, GENRE.FAMILY)));
        movies.add(new Movie("Universum", "Die international renommierte ORF-Reihe UNIVERSUM bietet zweimal pro " +
                "Woche" + " eindrucksvolle und qualitativ hochwertige Dokumentationen aus aller Welt.",
                List.of(GENRE.DOCUMENTARY)));

        //when
        Movie.sort(movies);

        //then
        assertAll("Check if the list of movies is in the right order",
                () -> assertEquals("Die Monster AG", movies.get(0).getTitle(), "First movie should be \"Die Monster AG\""),
                () -> assertEquals("SAW X", movies.get(1).getTitle(), "Second movie should be \"SAW X\""),
                () -> assertEquals("The Creator", movies.get(2).getTitle(), "Third movie should be \"The Creator\""),
                () -> assertEquals("Universum", movies.get(3).getTitle(), "Fourth movie should be \"Universum\"")
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
                GENRE.SCIENCE_FICTION)));
        movies.add(new Movie("SAW X", "Zwischen den Ereignissen von SAW I und II begibt sich John Kramer nach Mexiko,"
                + " um sich einer experimentellen medizinischen Behandlung zu unterziehen. Die Hoffnung auf eine " +
                "Wunderheilung treibt ihn an. Doch stattdessen entdeckt er, dass die gesamte Operation ein " +
                "teuflischer Betrug ist. Mit einem neuen Ziel vor Augen kehrt der berüchtigte Serienmörder zu seiner "
                + "Arbeit zurück: Er dreht den Spieß um und zieht die Betrüger auf seine ganz eigene, hinterhältige " +
                "und" + " raffinierte Art zur Rechenschaft.", List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME)));
        movies.add(new Movie("Die Monster AG",
                "In der Monster-AG-Fabrik gehen die Bösewichte eifrig ihrer Arbeit " + "nach: Über Schranktüren " +
                        "schleichen sie sich in Kinderzimmer ein und sammeln die Angstschreie ihrer " + "Bewohner, " +
                        "die den Strom für Monstropolis liefern. Ungekrönter Star unter den einfallsreichen " +
                        "\"Schreckeinjagern\" ist Sully. Dem passiert eines Tages ein folgenschweres Missgeschick: " +
                        "Das kleine" + " Mädchen Boo, dem er wie gewohnt einen kräftigen Schock versetzen will, " +
                        "verkrallt sich in sein Fell." + " Als er dann mit dem Kind in die Fabrik zurückkehrt, bricht" +
                        " das totale Chaos aus...", List.of(GENRE.ANIMATION, GENRE.COMEDY, GENRE.FAMILY)));
        movies.add(new Movie("Universum", "Die international renommierte ORF-Reihe UNIVERSUM bietet zweimal pro " +
                "Woche" + " eindrucksvolle und qualitativ hochwertige Dokumentationen aus aller Welt.",
                List.of(GENRE.DOCUMENTARY)));

        //when
        Movie.sort(movies, "asc");

        //then
        assertAll("Check if the list of movies is in the right order",
                () -> assertEquals("Die Monster AG", movies.get(0).getTitle(), "First movie should be \"Die Monster AG\""),
                () -> assertEquals("SAW X", movies.get(1).getTitle(), "Second movie should be \"SAW X\""),
                () -> assertEquals("The Creator", movies.get(2).getTitle(), "Third movie should be \"The Creator\""),
                () -> assertEquals("Universum", movies.get(3).getTitle(), "Fourth movie should be \"Universum\"")
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
                GENRE.SCIENCE_FICTION)));
        movies.add(new Movie("SAW X", "Zwischen den Ereignissen von SAW I und II begibt sich John Kramer nach Mexiko,"
                + " um sich einer experimentellen medizinischen Behandlung zu unterziehen. Die Hoffnung auf eine " +
                "Wunderheilung treibt ihn an. Doch stattdessen entdeckt er, dass die gesamte Operation ein " +
                "teuflischer Betrug ist. Mit einem neuen Ziel vor Augen kehrt der berüchtigte Serienmörder zu seiner "
                + "Arbeit zurück: Er dreht den Spieß um und zieht die Betrüger auf seine ganz eigene, hinterhältige " +
                "und" + " raffinierte Art zur Rechenschaft.", List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME)));
        movies.add(new Movie("Die Monster AG",
                "In der Monster-AG-Fabrik gehen die Bösewichte eifrig ihrer Arbeit " + "nach: Über Schranktüren " +
                        "schleichen sie sich in Kinderzimmer ein und sammeln die Angstschreie ihrer " + "Bewohner, " +
                        "die den Strom für Monstropolis liefern. Ungekrönter Star unter den einfallsreichen " +
                        "\"Schreckeinjagern\" ist Sully. Dem passiert eines Tages ein folgenschweres Missgeschick: " +
                        "Das kleine" + " Mädchen Boo, dem er wie gewohnt einen kräftigen Schock versetzen will, " +
                        "verkrallt sich in sein Fell." + " Als er dann mit dem Kind in die Fabrik zurückkehrt, bricht" +
                        " das totale Chaos aus...", List.of(GENRE.ANIMATION, GENRE.COMEDY, GENRE.FAMILY)));
        movies.add(new Movie("Universum", "Die international renommierte ORF-Reihe UNIVERSUM bietet zweimal pro " +
                "Woche" + " eindrucksvolle und qualitativ hochwertige Dokumentationen aus aller Welt.",
                List.of(GENRE.DOCUMENTARY)));

        //when
        Movie.sort(movies, "des");

        //then
        assertAll("Check if the list of movies is in the right order",
                () -> assertEquals("Universum", movies.get(0).getTitle(), "Firstmovie should be \"Universum\""),
                () -> assertEquals("The Creator", movies.get(1).getTitle(), "Second movie should be \"The Creator\""),
                () -> assertEquals("SAW X", movies.get(2).getTitle(), "Third movie should be \"SAW X\""),
                () -> assertEquals("Die Monster AG", movies.get(3).getTitle(), "Fourth  movie should be \"Die Monster AG\"")
        );
    }



    /*
     * * * * * * * *  SEARCH FILTER   * * * * * * * * *
     */
    @Test
    public void an_empty_search_query_has_to_show_all_movies() {
        //given
        String searchQuery = "";
        List<Movie> movies = new ArrayList<>();
        List<Movie> actual = new ArrayList<>();
        actual.addAll(movies);



        movies.add(new Movie("The Creator", "Inmitten eines künftigen Krieges zwischen der Menschheit und den " +
                "Kräften" + " der künstlichen Intelligenz wird Joshua, ein abgeklärter ehemaliger " +
                "Special-Forces-Agent, der um " + "seine verschwundene Frau trauert, rekrutiert, um den Creator zu " +
                "jagen und zu töten. Der Creator, ein" + " schwer fassbarer Architekt einer fortschrittlichen KI, " +
                "entwickelte eine mysteriöse Waffe, die den " + "Krieg zwar beenden kann, aber gleichzeitig auch die " +
                "Menschheit komplett auslöschen würde. Joshua und" + " sein Team bestehend aus Elite-Agenten, " +
                "durchqueren die feindlichen Linien und dringen in das dunkle" + " Herz des von der KI besetzten " +
                "Territoriums … Nur um herauszufinden, dass die weltverändernde Waffe," + " die er zerstören soll, " +
                "eine KI in Form eines kleinen Kindes ist.", List.of(GENRE.ACTION, GENRE.ADVENTURE,
                GENRE.SCIENCE_FICTION)));
        movies.add(new Movie("SAW X", "Zwischen den Ereignissen von SAW I und II begibt sich John Kramer nach Mexiko,"
                + " um sich einer experimentellen medizinischen Behandlung zu unterziehen. Die Hoffnung auf eine " +
                "Wunderheilung treibt ihn an. Doch stattdessen entdeckt er, dass die gesamte Operation ein " +
                "teuflischer Betrug ist. Mit einem neuen Ziel vor Augen kehrt der berüchtigte Serienmörder zu seiner "
                + "Arbeit zurück: Er dreht den Spieß um und zieht die Betrüger auf seine ganz eigene, hinterhältige " +
                "und" + " raffinierte Art zur Rechenschaft.", List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME)));
        movies.add(new Movie("Die Monster AG",
                "In der Monster-AG-Fabrik gehen die Bösewichte eifrig ihrer Arbeit " + "nach: Über Schranktüren " +
                        "schleichen sie sich in Kinderzimmer ein und sammeln die Angstschreie ihrer " + "Bewohner, " +
                        "die den Strom für Monstropolis liefern. Ungekrönter Star unter den einfallsreichen " +
                        "\"Schreckeinjagern\" ist Sully. Dem passiert eines Tages ein folgenschweres Missgeschick: " +
                        "Das kleine" + " Mädchen Boo, dem er wie gewohnt einen kräftigen Schock versetzen will, " +
                        "verkrallt sich in sein Fell." + " Als er dann mit dem Kind in die Fabrik zurückkehrt, bricht" +
                        " das totale Chaos aus...", List.of(GENRE.ANIMATION, GENRE.COMEDY, GENRE.FAMILY)));
        movies.add(new Movie("Universum", "Die international renommierte ORF-Reihe UNIVERSUM bietet zweimal pro " +
                "Woche" + " eindrucksvolle und qualitativ hochwertige Dokumentationen aus aller Welt.",
                List.of(GENRE.DOCUMENTARY)));

        // when

        //then
       // assertEquals(movies, searchResult);
    }

    @Test
    public void a_search_query_with_only_space_characters_has_to_show_all_movies() {

    }

    @Test
    public void uppercase_and_lowercase_letters_lead_to_the_same_results() {

    }

    @Test
    public void a_search_request_with_no_matches_has_no_result() {

    }

    @Test
    public void a_matching_query_and_title_lead_to_a_result() {

    }

    @Test
    public void a_matching_query_and_description_lead_to_a_result() {

    }
}