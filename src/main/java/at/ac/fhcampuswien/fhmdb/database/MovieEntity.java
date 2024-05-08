package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "movies")
public class MovieEntity {
    @DatabaseField(generatedId = true)     // will increase for new entries and avoids duplicates
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

    public MovieEntity(String apiId, String title, String description, String genres, int releaseYear, String imgUrl,
                       int lengthInMinutes, double rating) {
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

        return result.replace(result.length() - 2, result.length(), "").toString();
    }

    public static List<MovieEntity> fromMovies(List<Movie> movies) {
        return movies.stream().map(movie -> new MovieEntity(movie.getId(), movie.getTitle(), movie.getDescription(),
                genresToString(movie.getGenre()), movie.getReleaseYear(), movie.getImgUrl(),
                movie.getLengthInMinutes(), movie.getRating())).toList();
    }

    public static List<Movie> toMovie(List<MovieEntity> movieEntities) {
        List<Movie> movies = new ArrayList<>();

        for (MovieEntity me : movieEntities) {
            List<GENRE> genreList =
                    List.of(me.genres.split(", ")).stream().map(ge -> GENRE.valueOf(ge.toUpperCase())).toList();

            movies.add(new Movie(me.title, me.description, genreList, String.valueOf(me.id), me.releaseYear,
                    me.imgUrl, me.lengthInMinutes, List.of(), List.of(), List.of(), me.rating));
        }

        return movies;
    }

    public static Movie toMovie(MovieEntity movieEntity) {
        List<GENRE> genreList =
                List.of(movieEntity.genres.split(", ")).stream().map(ge -> GENRE.valueOf(ge.toUpperCase())).toList();

        return new Movie(movieEntity.title, movieEntity.description, genreList, String.valueOf(movieEntity.id),
                movieEntity.releaseYear, movieEntity.imgUrl, movieEntity.lengthInMinutes, null, null, null,
                movieEntity.rating);
    }

    public long getId() {
        return id;
    }

    public String getApiId() {
        return apiId;
    }
}
