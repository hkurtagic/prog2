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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.Comparator;
import javafx.event.ActionEvent;

public class HomeController implements Initializable {
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

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies); // Füge alle Filme zur beobachtbaren Liste hinzu

        movieListView.setItems(observableMovies); // Setze die Daten der beobachtbaren Liste in die ListView
        movieListView.setCellFactory(movieListView -> new MovieCell()); // Verwende eine benutzerdefinierte Zellenfabrik zur Anzeige der Daten

        List<String> genreList = new ArrayList<>();
        for (GENRE genre : GENRE.values()) {
            genreList.add(genre.toString().replaceAll("_", " "));
        }
        genreComboBox.getItems().addAll(genreList);
        genreComboBox.setPromptText("Filter by Genre");

        searchBtn.setOnAction(this::filterMovies);
        sortBtn.setOnAction(this::sortMovies);

        sortBtn.setText("Sort (asc)");
    }

    private void filterMovies(ActionEvent actionEvent) {
        String searchQuery = searchField.getText().toLowerCase();
        String selectedGenreStr = genreComboBox.getValue();
        GENRE selectedGenre = null;
        if (selectedGenreStr != null && !selectedGenreStr.isEmpty()) {
            selectedGenre = GENRE.valueOf(selectedGenreStr.replaceAll(" ", "_").toUpperCase());
        }
      
        // Search Button
        searchBtn.setOnAction(actionEvent -> {
            Movie.search(observableMovies, searchField.getText(), (String) genreComboBox.getValue(), allMovies);
        });

        clearBtn.setOnAction(actionEvent -> {
            genreComboBox.setValue(null);
        });
      
    private void sortMovies(ActionEvent actionEvent) {
        if (sortBtn.getText().equals("Sort (asc)")) {
            observableMovies.sort(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER));
            sortBtn.setText("Sort (desc)");
        } else {
            observableMovies.sort(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER).reversed());
            sortBtn.setText("Sort (asc)");
        }
    }
    private void clearFilters(ActionEvent actionEvent) {
        searchField.setText(""); //Löscht den Text aus dem Suchfeld
        genreComboBox.setValue(null); // Setzt die Auswahl im Genre-ComboBox zurück
        observableMovies.setAll(allMovies); // Setzt die Liste der Filme auf die ursprüngliche Liste zurück
    }
}