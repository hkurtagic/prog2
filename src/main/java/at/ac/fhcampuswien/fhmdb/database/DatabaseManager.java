package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Builds the connection between ORMLite table and H2 database engine
 */
public class DatabaseManager {
    public static final String DB_URL = "jdbc:h2:file: ./db/movieDB";
    public static final String username = "user";
    public static final String password = "pass";


    private static ConnectionSource conn;

    // Data Access Object pattern for DB-Operations
    private static Dao<MovieEntity, Long> dao;


    // Singleton Pattern to avoid establishment of multiple DB connections
    private static DatabaseManager instance;


    public Dao<MovieEntity, Long> getDao() {
        return this.dao;
    }

    // private constructor which cannot be called with new-keyword from outside the class
    private DatabaseManager() {
        try {
            createConnectionsSource();
            dao = DaoManager.createDao(conn, MovieEntity.class);    // create dao to do operations with db
            createTables();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static DatabaseManager getDatabaseInstance() {
        if (instance == null) {     // if no instance was created until now...
            instance = new DatabaseManager();
        }
        return instance;
    }

    private static void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(conn, MovieEntity.class);
    }

    private static void createConnectionsSource() throws SQLException {
        conn = new JdbcConnectionSource(DB_URL, username, password);
    }
}
