package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.MovieAPI;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import at.ac.fhcampuswien.fhmdb.utils.MovieUtils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HomeViewController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView<Movie> movieListView;

    @FXML
    public JFXComboBox<String> genreComboBox;

    @FXML
    public JFXButton sortBtn;

    @FXML
    public JFXButton clearBtn;


    // TODO: WIR MÜSSEN DIE BEIDEN COMBOBOXES NOCH IN DIE UI IN SCENE BUILDER EINFÜGEN!!!
    @FXML
    public JFXComboBox<Integer> releaseYearComboBox;

    @FXML
    public JFXComboBox<Double> ratingComboBox;

    @FXML
    public JFXButton homeBtn;
    @FXML
    public JFXButton aboutBtn;
    @FXML
    public JFXButton watchlistBtn;
    @FXML
    public BorderPane mainPane;    // to load in components

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically
    // updates corresponding UI elements when underlying data changes

    String currentView = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        List<String> genreList = new ArrayList<>();
        for (GENRE genre : List.of(GENRE.values())) {
            genreList.add(genre.toString().replaceAll("_", " "));
        }
        genreComboBox.getItems().addAll(genreList);

        releaseYearComboBox.setPromptText("Filter by Release Year");
        ratingComboBox.setPromptText("Filter by Rating");

        List<Integer> releaseYearList = new ArrayList<>();
        observableMovies.stream().filter(m -> ! releaseYearList.contains(m.getReleaseYear())).forEach((Movie m) -> releaseYearList.add(m.getReleaseYear()));
        Collections.sort(releaseYearList);
        releaseYearComboBox.getItems().addAll(releaseYearList);

        List<Double> ratingList = new ArrayList<>();
        observableMovies.stream().filter(m -> ! ratingList.contains(m.getRating())).forEach((Movie m) -> ratingList.add(m.getRating()));
        Collections.sort(ratingList);
        ratingComboBox.getItems().addAll((ratingList));

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // sort button
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)")) {
                sortBtn.setText("Sort (desc)");
                List<Movie> temp = sort(observableMovies, "asc");
                observableMovies.clear();
                observableMovies.addAll(temp);
            } else {
                sortBtn.setText("Sort (asc)");
                List<Movie> temp = sort(observableMovies, "desc");
                observableMovies.clear();
                observableMovies.addAll(temp);
            }
        });

        // search button
        searchBtn.setOnAction(actionEvent -> {

            String searchQuery = searchField.getText();
            String genre = genreComboBox.getValue();
            Double rating = ratingComboBox.getValue();
            Integer releaseYear = releaseYearComboBox.getValue();

            List<Movie> result = null;
            try {
                // searching query
                result = MovieAPI.fetchMovies(searchQuery.isBlank() ? null : searchQuery, genre, releaseYear, rating);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            observableMovies.clear();
            observableMovies.addAll(result);

            // Update of release years in combobox when search criteria are applied
            handleElements();
        });

        // clear button
        clearBtn.setOnAction(actionEvent -> {
            // unset selected genre
            genreComboBox.setValue(null);
            releaseYearComboBox.setValue(null);
            ratingComboBox.setValue(null);
            searchField.setText("");

            String searchQuery = searchField.getText();

            // call of search method which also filters by genre
            List<Movie> result = new MovieUtils(allMovies).search(searchQuery).build();
            observableMovies.clear();
            observableMovies.addAll(allMovies);

            handleElements();
        });

    }

    public static List<Movie> sort(List<Movie> movieList, String order) {
        List<Movie> modifiableList = new ArrayList<>(movieList);
        if (order.equals("desc")) {
            modifiableList.sort(Movie::compareTo);
            Collections.reverse(modifiableList);
        } else {
            modifiableList.sort(Movie::compareTo);
        }
        return modifiableList;
    }

    public static String getMostPopularActor(List<Movie> movies) {
        Map<String, Integer> actors = new HashMap<>();
        List<Object> mostPopularActor = new ArrayList<>(List.of("", 0));

        movies.stream().forEach(movie -> movie.getMainCast().stream().forEach(a -> {
            if (actors.containsKey(a)) {
                actors.replace(a, actors.get(a) + 1);
            } else {
                actors.put(a, 1);
            }
        }));

        actors.entrySet().stream().forEach(actor -> {
            if (actor.getValue() > (int) mostPopularActor.get(1)) {
                mostPopularActor.set(0, actor.getKey());
                mostPopularActor.set(1, actor.getValue());
            }
        });

        return (String) mostPopularActor.get(0);
    }

    public static List<Movie> getMoviesBetweenYears(List<Movie> movies, int startYear, int endYear) {
        return movies.stream()
                .filter((Movie movie) -> movie.getReleaseYear() <= endYear && movie.getReleaseYear() >= startYear)
                .toList();
    }

    public static int getLongestMovieTitle(List<Movie> movies) {
        return movies.stream()
                .map(Movie::getTitle)
                .mapToInt(String::length) // Map each title to its length
                .max() // find max length
                .orElse(0); // return 0 if movie list is empty
    }

    public static long countMoviesFrom(List<Movie> movies, String directors) {
        return movies.stream()
                .filter((Movie movie) -> movie.getDirectors().contains(directors)) // Filter movies by director
                .count(); // Count the filtered movies
    }

    private void handleElements() {
        Integer releaseYearComboBoxValue = releaseYearComboBox.getValue();
        List<Integer> tempReleaseYear = new ArrayList<>();
        observableMovies.stream().filter(m -> !tempReleaseYear.contains(m.getReleaseYear())).forEach((Movie m) -> tempReleaseYear.add(m.getReleaseYear()));
        Collections.sort(tempReleaseYear);
        releaseYearComboBox.getItems().clear();
        releaseYearComboBox.getItems().addAll(tempReleaseYear);
        releaseYearComboBox.setValue(releaseYearComboBoxValue);

        Double ratingComboBoxValue = ratingComboBox.getValue();
        List<Double> tempRatingList = new ArrayList<>();
        observableMovies.stream().filter(m -> ! tempRatingList.contains(m.getRating())).forEach((Movie m) -> tempRatingList.add(m.getRating()));
        Collections.sort(tempRatingList);
        ratingComboBox.getItems().clear();
        ratingComboBox.getItems().addAll((tempRatingList));
        ratingComboBox.setValue(ratingComboBoxValue);
    }


    //MovieEntity.genresToString();
 }
