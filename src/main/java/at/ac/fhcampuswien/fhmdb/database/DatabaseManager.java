package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseManager {
    public static final String DB_URL = "jdbc:h2:file: ./db/movieDB";
    public static final String username = "user";
    public static final String password = "pass";

    private static ConnectionSource conn;

    private static Dao<MovieEntity, Long> dao;
    private static Dao<WatchlistMovieEntity, Long> watchListDao;

    private static DatabaseManager instance;

    // private constructor which cannot be called with new-keyword from outside the class
    private DatabaseManager() {
        try {
            createConnectionsSource();
            dao = DaoManager.createDao(conn, MovieEntity.class);
            watchListDao = DaoManager.createDao(conn, WatchlistMovieEntity.class); // Initialize watchListDao
            createTables();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Singleton Pattern to avoid establishment of multiple DB connections
    public static DatabaseManager getDatabaseInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    private static void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(conn, MovieEntity.class);
        TableUtils.createTableIfNotExists(conn, WatchlistMovieEntity.class); // Create table for WatchlistMovieEntity
    }

    private static void createConnectionsSource() throws SQLException {
        conn = new JdbcConnectionSource(DB_URL, username, password);
    }

    public static Dao<MovieEntity, Long> getDao() {
        return dao;
    }

    public static Dao<WatchlistMovieEntity, Long> getWatchlistDao() throws SQLException {
        return watchListDao;
    }
}