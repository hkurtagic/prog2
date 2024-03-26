package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    @FXML
    public JFXButton clearBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        List<String> genreList = new ArrayList<>();
        for (GENRE genre:List.of(GENRE.values())) {
            genreList.add(genre.toString().replaceAll("_", " "));
        }
        genreComboBox.getItems().addAll(genreList);


        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // sort button
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                sortBtn.setText("Sort (desc)");
                sort(observableMovies, "asc");
            } else {
                sortBtn.setText("Sort (asc)");
                sort(observableMovies, "des");
            }
        });

        // search button
        searchBtn.setOnAction(actionEvent -> {
            // call of search method which also filters by genre
            List<Movie> result = filteredSearch(searchField.getText(), (String) genreComboBox.getValue(), allMovies);
            observableMovies.clear();
            observableMovies.addAll(result);
        });

        // clear button
        clearBtn.setOnAction(actionEvent -> {
            // unset selected genre
            genreComboBox.setValue(null);
            // call of search method which also filters by genre
            List<Movie> result = filteredSearch(searchField.getText(), (String) genreComboBox.getValue(), allMovies);
            observableMovies.clear();
            observableMovies.addAll(result);
        });
    }




    public static List<Movie> filterGenre(String genre, List<Movie> allMovies) {
        if (genre == null) {
            return allMovies;
        } else {
            List<Movie> searchResult = new ArrayList<>();

            for (Movie movie : allMovies) {
                List<String> genreList = new ArrayList<>();

                // add Genres as a String to genreList
                movie.getGenre().forEach(g -> genreList.add(g.toString()));

                if (genreList.contains(genre)) searchResult.add(movie);
            }

            return searchResult;

        }
    }

    /*
     * The following search method only covers the search function without filters
     */

    public static List<Movie> unfilteredSearch(String searchQuery, List<Movie> allMovies) {    // allMovies is the Movie base which will be searched through
        List<Movie> searchResults = new ArrayList<>();
        if (searchQuery.isBlank()) {    // checks for whitespaces or empty query
            searchResults.addAll(allMovies);
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

        }
        return searchResults;
    }

    /*
     *  The following search method combines search and filter functionality
     */
    public static List<Movie> filteredSearch(String searchQuery, String genre, List<Movie> allMovies) {    // allMovies is the Movie base which will be searched through
        List<Movie> searchResults = new ArrayList<>();
        if (genre == null) {
            // call of normal search method
            searchResults.addAll(unfilteredSearch(searchQuery, allMovies));
        } else {
            if (searchQuery.isBlank()) {    // checks for whitespaces or empty query
                // call of filter method
                searchResults.addAll(filterGenre(genre, allMovies));
            } else {
                // first do the search algorithm
                for (Movie movie : allMovies) {
                    if (movie.getTitle().toLowerCase().contains(searchQuery.toLowerCase()) || movie.getDescription().toLowerCase().contains(searchQuery.toLowerCase())) {
                        searchResults.add(movie);
                        System.out.println(movie.getTitle());
                    }
                }

                // then filter search results
                List<Movie> result = filterGenre(genre, searchResults);
                searchResults.clear();
                searchResults.addAll(result);

                // terminal output of search results
                System.out.println("\nSearch-Results\n");
                for (Movie movie : searchResults) {
                    System.out.println(movie.getTitle());
                }
            }
        }
        return searchResults;
    }

    public static void sort(List<Movie> movieList, String order) {
        if (order.equals("des")) {
            movieList.sort(Movie::compareTo);
            Collections.reverse(movieList);
        } else {
            movieList.sort(Movie::compareTo);
        }
    }
}