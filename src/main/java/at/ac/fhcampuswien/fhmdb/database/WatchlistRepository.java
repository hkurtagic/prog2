package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WatchlistRepository {
    Dao<WatchlistMovieEntity, Long> dao;

    public WatchlistRepository() throws SQLException {
        DatabaseManager.getDatabaseInstance();
        dao = DatabaseManager.getWatchlistDao();
    }

    public List<WatchlistMovieEntity> getAll() throws SQLException {
        return dao.queryForAll();
    }

    public void deleteAll(List<WatchlistMovieEntity> movieEntityList) throws SQLException {
        dao.delete(movieEntityList);
    }

    public void add(WatchlistMovieEntity me) throws SQLException {
        if (dao.queryForEq("apiId", me.getApiId()).stream().toList().isEmpty()) {
            dao.create(me);
        }
    }

    public void addAll(List<WatchlistMovieEntity> me) throws SQLException {
        me.stream().map(m -> {
            try {
                if (dao.queryForEq("apiId", m.getApiId()).stream().toList().isEmpty()) {
                    return dao.create(m);
                } else {
                    return null;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void delete(WatchlistMovieEntity me) throws SQLException {
        dao.delete(me);
    }

    public List<Movie> toMovies(List<WatchlistMovieEntity> wlmel) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        MovieRepository movieRepository = new MovieRepository();

        wlmel.stream().map((wlme) -> {
            try {
                return movieRepository.get(wlme.getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }).map((MovieEntity::toMovie)).forEach(movies::addAll);

        return movies;
        }
}
