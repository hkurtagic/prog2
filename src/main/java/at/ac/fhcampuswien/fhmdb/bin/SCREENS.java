package at.ac.fhcampuswien.fhmdb.bin;

public enum SCREENS {
    HOME("/at/ac/fhcampuswien/fhmdb/home-view.fxml"),
    ABOUT("/at/ac/fhcampuswien/fhmdb/about-view.fxml"),
    WATCHLIST("/at/ac/fhcampuswien/fhmdb/watchlist-view.fxml");


    public final String path;

    SCREENS(String path) {
        this.path = path;
    }
}
