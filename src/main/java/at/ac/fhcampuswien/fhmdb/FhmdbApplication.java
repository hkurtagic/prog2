package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.database.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource("/at/ac/fhcampuswien/fhmdb/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 930, 620);
        scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("styles.css")).toExternalForm());
        stage.setTitle("FHMDb");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

/*
 *  TODO
 *   1) WATCHLIST-ENTITY- UND REPOSITORY KLASSE ADDEN
 *   2) Umsetzung der „To Watchlist“/“remove“ Funktionen im Controller/Business Logic Layer.
 *       Diese werden mithilfe von Lambda Expressions, Functional Interface und entsprechenden Callback realisiert.
 *   3) Exception Handling ist implementiert. Dazu werden zwei Custom Exception Klassen
 *   (MovieAPIException und DatabaseException) genutzt. Exceptions werden, wo sinnvoll, an
 *   die Controller Klasse(n) propagiert und gehandelt. Wenn eine MovieAPIException beim
 *   Abrufen der API auftritt, werden die zuvor gecachten Filme aus der DB geladen. (3 Pkt.)
 */