package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.util.stream.Collectors;

public class Movie implements Comparable<Movie> {
    private String title;
    private String description;

    // TODO add more properties here
    private List<GENRE> genres; // Die Genre-Liste für den Film

    static List<Movie> movies = new ArrayList<>();

    public Movie(String title, String description, List<GENRE> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List getGenre() {
        return genres;
    }

    public static List<Movie> initializeMovies() {

        // TODO add some dummy data here
        movies.add(new Movie("SAW X", "The film sees John Kramer (Bell) travelling to Mexico in hopes that an " +
                                      "experimental procedure may cure his terminal cancer. John later discovers that" +
                                      " the operation is a " + "scam, prompting him to kidnap those responsible and " +
                                      "subject them to his trademark death traps as " + "retribution.",
                List.of(GENRE.HORROR, GENRE.ACTION, GENRE.CRIME)));

        movies.add(new Movie("Titanic", "A poor boy and a rich girl fall in love on a ship. The ship sinks. He dies."
                , List.of(GENRE.ROMANCE, GENRE.HISTORY, GENRE.DRAMA)));

        movies.add(new Movie("IT", "A clown eats children's souls", List.of(GENRE.HORROR, GENRE.COMEDY,
                GENRE.FANTASY)));

        /*
         * The following 19 lines of Code have been taken from the Internet | https://chat.openai
         * .com/c/98b82e31-ad26-4efa-bbe3-cc0e2c006586, last visit: 02.03.2024
         */
        movies.add(new Movie("The Dark Knight",
                "A gritty portrayal of Batman facing the Joker's chaotic reign of " + "terror in Gotham City.",
                List.of(GENRE.ACTION, GENRE.CRIME, GENRE.DRAMA)));

        movies.add(new Movie("Avengers: Endgame",
                "The epic conclusion to the Avengers saga as they attempt to undo " + "the devastating events caused "
                + "by the villain Thanos.", List.of(GENRE.ACTION, GENRE.ADVENTURE, GENRE.SCIENCE_FICTION)));

        movies.add(new Movie("Black Panther",
                "T'Challa, the king of Wakanda, must defend his nation and the world " + "as" + " the superhero " +
                "Black" + " Panther.", List.of(GENRE.ACTION, GENRE.ADVENTURE, GENRE.SCIENCE_FICTION)));

        movies.add(new Movie("Wonder Woman", "Diana, an Amazonian princess, discovers her true destiny as Wonder " +
                                             "Woman and faces the challenges of World War I.", List.of(GENRE.ACTION,
                GENRE.ADVENTURE,
                GENRE.FANTASY)));

        movies.add(new Movie("Spider-Man: Into the Spider-Verse",
                "Miles Morales discovers the multiverse and teams " + "up with other Spider-People from different " +
                "dimensions to save all of reality.", List.of(GENRE.ACTION, GENRE.ADVENTURE, GENRE.ANIMATION)));

        movies.add(new Movie("The Shawshank Redemption",
                "A tale of friendship and survival as two imprisoned men " + "bond over several decades, finding " +
                "solace and redemption in unlikely circumstances.", List.of(GENRE.DRAMA)));

        movies.add(new Movie("The Grand Budapest Hotel", "A quirky comedy about the misadventures of a hotel " +
                                                         "concierge and his protege as they become embroiled in a " +
                                                         "theft and murder mystery.",
                List.of(GENRE.COMEDY)));

        movies.add(new Movie("Blade Runner 2049", "In a dystopian future, a blade runner discovers a long-buried " +
                                                  "secret that has the potential to plunge society into chaos.",
                List.of(GENRE.SCIENCE_FICTION,
                        GENRE.THRILLER)));

        movies.add(new Movie("La La Land",
                "A modern musical about an aspiring actress and a jazz musician who meet " + "and fall in love while "
                + "pursuing their dreams in Los Angeles.", List.of(GENRE.ROMANCE, GENRE.MUSICAL, GENRE.DRAMA)));

        movies.add(new Movie("Gone Girl",
                "A psychological thriller that explores the disappearance of a woman and " + "the media frenzy " +
                "surrounding the investigation.", List.of(GENRE.MYSTERY, GENRE.DRAMA, GENRE.THRILLER)));

        return movies;
    }

    public static void sort(List<Movie> movieList) {
        movieList.sort(Movie::compareTo);
    }

    public static void sort(List<Movie> movieList, String order) {
        if (order.equals("des")) {
            movieList.sort(Movie::compareTo);
            Collections.reverse(movieList);
        } else {
            movieList.sort(Movie::compareTo);
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


    public static void search(List<Movie> observalbeMovies, String searchQuery, List<Movie> allMovies) {    // allMovies is the Movie base which will be searched through
        List<Movie> searchResults = new ArrayList<>();

        if (searchQuery.isBlank()) {    // checks for whitespaces or empty query
            observalbeMovies.clear();
            observalbeMovies.addAll(allMovies);
        } else {
            for (Movie movie : allMovies) {
                if (movie.getTitle().toLowerCase().contains(searchQuery.toLowerCase()) || movie.getDescription().toLowerCase().contains(searchQuery.toLowerCase())) {
                    searchResults.add(movie);
                    System.out.println(movie.getTitle());
                }
            }

            // terminal output of search results
            System.out.println("\nSearch-Results\n");
            for (Movie movie : searchResults) {
                System.out.println(movie.getTitle());
            }

            observalbeMovies.clear();
            observalbeMovies.addAll(searchResults);
        }
    }
}