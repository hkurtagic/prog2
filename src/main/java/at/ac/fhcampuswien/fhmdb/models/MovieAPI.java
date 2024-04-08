package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.bin.GENRE;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MovieAPI {
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();
    private static final String BASE_URL = "https://prog2.fh-campuswien.ac.at/movies";


    // Method to get the movies with selected criteria
    public static List<Movie> fetchMovies(String query, GENRE genre, Integer releaseYear, Double rating) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL).newBuilder();

        if (query != null && !query.isEmpty()) {
            urlBuilder.addQueryParameter("query", query);
        }
        if (genre != null) {
            urlBuilder.addQueryParameter("genre", genre.name());
        }
        if (releaseYear != null) {
            urlBuilder.addQueryParameter("releaseYear", releaseYear.toString());
        }
        if (rating != null) {
            urlBuilder.addQueryParameter("rating", rating.toString());
        }

        /*
         * Handling the request
         */
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("User-Agent", "http.agent")
                .build();


        /*
         * Handling the response: ATTENTION: WE USED SYNCHRONOUS GET!!
         */
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Type listType = new TypeToken<ArrayList<Movie>>(){}.getType();
            return gson.fromJson(response.body().string(), listType);
        }
    }
}
