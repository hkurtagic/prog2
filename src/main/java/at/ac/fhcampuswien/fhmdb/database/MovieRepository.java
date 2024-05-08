package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class MovieRepository {
    Dao<MovieEntity, Long> dao;

    public MovieRepository() {
        DatabaseManager.getDatabaseInstance();
        dao = DatabaseManager.getDao();
    }

    public List<MovieEntity> get(String title) throws SQLException {
        QueryBuilder<MovieEntity, Long> queryBuilder = dao.queryBuilder().where().eq("title", title).queryBuilder();
        return queryBuilder.query();
    }

    public List<MovieEntity> get(long id) throws SQLException {
        QueryBuilder<MovieEntity, Long> queryBuilder = dao.queryBuilder().where().eq("id", id).queryBuilder();
        return queryBuilder.query();
    }

    public List<MovieEntity> getAll() throws SQLException {
        return dao.queryForAll();
    }

    public void deleteAll(List<MovieEntity> movieEntityList) throws SQLException {
        dao.delete(movieEntityList);
    }

    public void add(MovieEntity me) throws SQLException {
        dao.createIfNotExists(me);
    }

    public void addAll(List<MovieEntity> me) throws SQLException {
        me.stream().map(m -> {
            try {
                return dao.createIfNotExists(m);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void delete(MovieEntity me) throws SQLException {
        dao.delete(me);
    }
}
