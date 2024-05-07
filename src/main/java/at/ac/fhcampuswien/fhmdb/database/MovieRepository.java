package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Abstahiert, was man mit DAO machen kann...
 */
public class MovieRepository {
    Dao<MovieEntity, Long> dao;

    public MovieRepository() {
        try {
            this.dao = DatabaseManager.getDatabaseInstance().getDao();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing Movie DAO", e);
        }
    }

    // Abstraktionen für die Aktionen mit DAO
    public List<MovieEntity> getAllMovies() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Remove all movies with a specific apiId
    public int removeAll(String apiId) {
        try {
            DeleteBuilder<MovieEntity, Long> deleteBuilder = dao.deleteBuilder();
            deleteBuilder.where().eq("apiId", apiId);
            return deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Retrieve the first movie from the database
    public MovieEntity getMovie() {
        try {
            return dao.queryForFirst(dao.queryBuilder().prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Add a list of movies to the database
    public int addAllMovies(List<Movie> movies) {
        int count = 0;
        try {
            for (MovieEntity movieEntity : MovieEntity.fromMovies(movies)) {
                dao.create(movieEntity);
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
