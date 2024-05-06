package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.enums.Screens;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainViewController {
    public String currentView = Screens.HOME.path;

    @FXML
    public JFXButton homeBtn;
    @FXML
    public JFXButton aboutBtn;
    @FXML
    public JFXButton watchlistBtn;
    @FXML
    public BorderPane mainPane;    // to load in components


    public void initialize() {
        setContentView(Screens.HOME.path);
    }

    public void setContentView(String pathToView) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathToView));     // getClass() damit man Ressourcen korrekt von der aktuellen Klasse aus erreicht

        try {
            mainPane.setCenter(fxmlLoader.load());      // liest Pfad aus Ressourcen und lädt FXML File in die Application
        } catch (IOException e) {
            System.out.println("Error while loading the view.");
        }
    }

    public void loadHomeView() {
        if (currentView != Screens.HOME.path) {
            setContentView(Screens.HOME.path);
            currentView = Screens.HOME.path;
        }
    }

    public void loadWatchlistView() {
        if (currentView != Screens.WATCHLIST.path) {
            setContentView(Screens.WATCHLIST.path);
            currentView = Screens.WATCHLIST.path;
        }
    }

    public void loadAboutView() {
        if (currentView != Screens.ABOUT.path) {
            setContentView(Screens.ABOUT.path);
            currentView = Screens.ABOUT.path;
        }
    }
}
