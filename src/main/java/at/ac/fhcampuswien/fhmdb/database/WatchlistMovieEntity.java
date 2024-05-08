package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "watchlistMovies")
public class WatchlistMovieEntity {
    @DatabaseField(generatedId = true)     // will increase for new entries and avoids duplicates
    private long id;

    @DatabaseField()
    private String apiId;

    public WatchlistMovieEntity() {}

    public WatchlistMovieEntity(long id, String apiId) {
        this.id = id;
        this.apiId = apiId;
    }

    public long getId() {
        return id;
    }

    public String getApiId() {
        return apiId;
    }

    public static WatchlistMovieEntity toWatchlistMovieEntry(MovieEntity movieEntity) {
        return new WatchlistMovieEntity(movieEntity.getId(), movieEntity.getApiId());
    }
}
