package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.controllers.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.database.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.database.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WatchlistViewController implements Initializable {
    @FXML
    public JFXListView<WatchlistMovieEntity> watchlistView;

    private final ObservableList<WatchlistMovieEntity> observableMovies = FXCollections.observableArrayList();

    // Define click handler for removing movies from the watchlist
    private final ClickEventHandler<WatchlistMovieEntity> onRemoveFromWatchlistClicked = (clickedItem) -> {
        WatchlistRepository watchlistRepo = new WatchlistRepository();
        watchlistRepo.removeFromWatchlist(clickedItem.getApiId()); // Remove from database
        observableMovies.remove(clickedItem); // Remove from the displayed list
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize the watchlist from the database
        WatchlistRepository watchlistRepo = new WatchlistRepository();
        List<WatchlistMovieEntity> watchlist = watchlistRepo.getWatchlist();
        observableMovies.addAll(watchlist);

        watchlistView.setItems(observableMovies);
        // Pass the click handler to the MovieCell
        watchlistView.setCellFactory(watchlistView -> new MovieCell(null, onRemoveFromWatchlistClicked));
    }
}
