package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

public class WatchlistRepository {
    private final Dao<WatchlistMovieEntity, Long> dao;

    public WatchlistRepository() {
        try {
            // Ensure this method correctly returns the Watchlist DAO
            this.dao = DatabaseManager.getDatabaseInstance().getWatchlistDao();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing Watchlist DAO", e);
        }
    }

    // Retrieve all watchlist movies from the database
    public List<WatchlistMovieEntity> getWatchlist() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Add a movie to the watchlist
    public int addToWatchlist(WatchlistMovieEntity movie) {
        try {
            return dao.create(movie);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // Return 0 indicating failure
        }
    }

    // Remove a movie from the watchlist by apild
    public int removeFromWatchlist(String apild) {
        try {
            // Ensure the DAO returns the correct DeleteBuilder
            DeleteBuilder<WatchlistMovieEntity, Long> deleteBuilder = dao.deleteBuilder();
            deleteBuilder.where().eq("apild", apild);
            return deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
