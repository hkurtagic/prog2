package at.ac.fhcampuswien.fhmdb.enums;

public enum Screens {
    HOME("/at/ac/fhcampuswien/fhmdb/home-view.fxml"),
    ABOUT("/at/ac/fhcampuswien/fhmdb/about-view.fxml"),
    WATCHLIST("/at/ac/fhcampuswien/fhmdb/watchlist-view.fxml");


    public final String path;

    Screens(String path) {
        this.path = path;
    }
}
