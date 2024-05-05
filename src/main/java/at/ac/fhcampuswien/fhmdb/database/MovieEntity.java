package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "movies")
public class MovieEntity {
    @DatabaseField (generatedId = true)     // will increase for new entries and avoids duplicates
    private long id;
    @DatabaseField()
    private String apiId;
    @DatabaseField
    private String title;
    @DatabaseField
    private String description;
    @DatabaseField
    private String genres;
    @DatabaseField
    private int releaseYear;
    @DatabaseField
    private String imgUrl;
    @DatabaseField
    private int lengthInMinutes;
    @DatabaseField
    private double rating;

    public MovieEntity() {
        /* Default Constructor */
    }

    public MovieEntity(String apiId, String title, String description, String genres, int releaseYear, String imgUrl, int lengthInMinutes, double rating) {
        this.apiId = apiId;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }

    public static String genresToString(List<GENRE> genres) {
        StringBuilder result = new StringBuilder();
        genres.stream().forEach((genre -> result.append(genre.toString()).append(", ")));

        return result.replace(result.length()-2, result.length(), "").toString();
    }



    List<MovieEntity> fromMovies(List<Movie> movies) {
        return null;
    }
}
