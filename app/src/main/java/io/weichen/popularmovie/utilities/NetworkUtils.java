package io.weichen.popularmovie.utilities;

import android.net.Uri;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static io.weichen.popularmovie.BuildConfig.THEMOVIEDB_API_KEY;

public class NetworkUtils {
    final static String THEMOVIEDB_BASE_URL = "http://api.themoviedb.org/3/movie";
    public final static String CATEGORY_POPULAR = "popular";
    public final static String CATEGOry_TOP_RATED ="top_rated";
    final static String PAGE = "page";
    final static String PAGE_NUMBER = "1";
    final static String API_KEY = "api_key";


    /**
     * Builds the URL used to query The Movie DB.
     *
     */
    public static URL buildUrl(@Nullable String category) {
        Uri builtUri = Uri.parse(THEMOVIEDB_BASE_URL).buildUpon()
                .appendPath(category)
                .appendQueryParameter(PAGE, PAGE_NUMBER)
                .appendQueryParameter(API_KEY, THEMOVIEDB_API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
