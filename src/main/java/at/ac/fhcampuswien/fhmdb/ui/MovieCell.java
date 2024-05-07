package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.controllers.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.database.MovieEntity;
import at.ac.fhcampuswien.fhmdb.database.WatchlistMovieEntity;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.stream.Collectors;

public class MovieCell extends ListCell<WatchlistMovieEntity> {
    private final Label title = new Label();
    private final Label detail = new Label();
    private final Label genre = new Label();
    private final JFXButton detailBtn = new JFXButton("Show Details");
    private final JFXButton addToWatchlistBtn = new JFXButton("Add to watchlist");
    private final JFXButton removeFromWatchlistBtn = new JFXButton("Remove");
    private final VBox layout = new VBox(title, detail, genre, addToWatchlistBtn, detailBtn, removeFromWatchlistBtn);

    private boolean collapsedDetails = true;

    public MovieCell(ClickEventHandler<MovieEntity> addToWatchlistClicked,
                     ClickEventHandler<WatchlistMovieEntity> removeFromWatchlistClicked) {
        super();
        // color scheme and layout
        detailBtn.setStyle("-fx-background-color: #f5c518;");
        addToWatchlistBtn.setStyle("-fx-background-color: #f5c518;");
        removeFromWatchlistBtn.setStyle("-fx-background-color: #f5c518;");
        title.getStyleClass().add("text-yellow");
        detail.getStyleClass().add("text-white");
        genre.getStyleClass().add("text-white");
        genre.setStyle("-fx-font-style: italic");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));
        layout.setPadding(new Insets(10));
        layout.spacingProperty().set(10);
        layout.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);
        title.fontProperty().set(title.getFont().font(20));
        detail.setWrapText(true);

        detailBtn.setOnMouseClicked(mouseEvent -> {
            if (collapsedDetails) {
                layout.getChildren().add(getDetails());
                collapsedDetails = false;
                detailBtn.setText("Hide Details");
            } else {
                layout.getChildren().remove(5);
                collapsedDetails = true;
                detailBtn.setText("Show Details");
            }
            setGraphic(layout);
        });

        addToWatchlistBtn.setOnMouseClicked(mouseEvent -> addToWatchlistClicked.onClick(getItem()));
        removeFromWatchlistBtn.setOnMouseClicked(mouseEvent -> removeFromWatchlistClicked.onClick(getItem()));
    }

    private VBox getDetails() {
        VBox details = new VBox();
        Label releaseYear = new Label("Release Year: " + getItem().getReleaseYear());
        Label length = new Label("Length: " + getItem().getLengthInMinutes() + " minutes");
        Label rating = new Label("Rating: " + getItem().getRating() + "/10");

       // Label directors = new Label("Directors: " + getItem().getDirectors());
       // Label writers = new Label("Writers: " + getItem().getWriters());
       // Label mainCast = new Label("Main Cast: " + getItem().getMainCast());

        releaseYear.getStyleClass().add("text-white");
        length.getStyleClass().add("text-white");
        rating.getStyleClass().add("text-white");
       // directors.getStyleClass().add("text-white");
       // writers.getStyleClass().add("text-white");
      //  mainCast.getStyleClass().add("text-white");

        details.getChildren().add(releaseYear);
        details.getChildren().add(rating);
        details.getChildren().add(length);
      //  details.getChildren().add(directors);
      //  details.getChildren().add(writers);
     //   details.getChildren().add(mainCast);
        return details;
    }

    @Override
    protected void updateItem(WatchlistMovieEntity movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setGraphic(null);
            setText(null);
        } else {
            this.getStyleClass().add("movie-cell");
            title.setText(movie.getTitle());
            detail.setText(
                    movie.getDescription() != null
                            ? movie.getDescription()
                            : "No description available"
            );

            String genres = movie.getGenres();
            genre.setText(genres);

            detail.setMaxWidth(this.getScene().getWidth() - 30);

            setGraphic(layout);
        }
    }
}
