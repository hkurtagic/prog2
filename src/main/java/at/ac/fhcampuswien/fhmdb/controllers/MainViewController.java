package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.bin.SCREENS;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainViewController {



    public String currentView = SCREENS.HOME.path;

    @FXML
    public JFXButton homeBtn;
    @FXML
    public JFXButton aboutBtn;
    @FXML
    public JFXButton watchlistBtn;
    @FXML
    public BorderPane mainPane;    // to load in components

    public void initialize() {
        setContentView(SCREENS.HOME.path);
    }

    public void setContentView(String pathToView) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathToView));     // getClass() damit man Ressourcen korrekt von der aktuellen Klasse aus erreicht

        try {
            mainPane.setCenter(fxmlLoader.load());      // liest Pfad aus Ressourcen und lädt FXML File in die Application
        } catch (IOException e) {
            System.out.println("Error while loading the view: ");
            e.printStackTrace();
        }
    }

    public void loadHomeView() {
        if (currentView != SCREENS.HOME.path) {
            setContentView(SCREENS.HOME.path);
            currentView = SCREENS.HOME.path;
        }
    }

    public void loadWatchlistView() {
        if (currentView != SCREENS.WATCHLIST.path) {
            setContentView(SCREENS.WATCHLIST.path);
            currentView = SCREENS.WATCHLIST.path;
        }
    }

    public void loadAboutView() {
        if (currentView != SCREENS.ABOUT.path) {
            setContentView(SCREENS.ABOUT.path);
            currentView = SCREENS.ABOUT.path;
        }
    }
}
