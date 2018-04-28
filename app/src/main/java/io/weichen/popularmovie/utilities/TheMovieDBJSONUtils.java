package io.weichen.popularmovie.utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

import io.weichen.popularmovie.MovieData;

public class TheMovieDBJSONUtils {
    private static final String TMDB_RESULTS = "results";
    private static final String TMDB_TITLE = "title";
    private static final String TMDB_POSTER_PATH = "poster_path";
    private static final String TMDB_OVERVIEW = "overview";
    private static final String TMDB_VOTE_AVERAGE = "vote_average";
    private static final String TMDB_RELEASE_DATE = "release_date";


    public static ArrayList<MovieData> getMovieDataFromJSON(String movieDataJSONStr) throws JSONException {
        ArrayList<MovieData> movieDataArraylist = new ArrayList<>();
        JSONObject movieDataJSON = new JSONObject(movieDataJSONStr);

        //TODO: check if there any error in the jason message.
        JSONArray jsonMovieResultArray = movieDataJSON.getJSONArray(TMDB_RESULTS);

        //Get JsonObject in the loop
        for(int i= 0;i < jsonMovieResultArray.length();i++){

            String title;
            String posterPath;
            String overview;
            String voteAverage;
            String releaseDate;

            JSONObject movieJSON = jsonMovieResultArray.getJSONObject(i);

            title = movieJSON.getString(TMDB_TITLE);
            posterPath = movieJSON.getString(TMDB_POSTER_PATH);
            overview = movieJSON.getString(TMDB_OVERVIEW);
            voteAverage = movieJSON.getString(TMDB_VOTE_AVERAGE);
            releaseDate = movieJSON.getString(TMDB_RELEASE_DATE);

            //Use the the above info to create new movie item and added to ArrayList
            movieDataArraylist.add(new MovieData(title,posterPath,overview,voteAverage,releaseDate));
        }
        return movieDataArraylist;
    }
}
