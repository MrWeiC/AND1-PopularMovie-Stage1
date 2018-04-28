package io.weichen.popularmovie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import io.weichen.popularmovie.utilities.NetworkUtils;

import static io.weichen.popularmovie.utilities.NetworkUtils.CATEGORY_POPULAR;
import static io.weichen.popularmovie.utilities.TheMovieDBJSONUtils.getMovieDataFromJSON;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    //TODO: Needs to be deleted
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (TextView)findViewById(R.id.test);
        //DELETE
        makeTheMovieDBQuery();
    }

    private void makeTheMovieDBQuery(){
        URL theMovieDBUrl = NetworkUtils.buildUrl(CATEGORY_POPULAR);

        new TheMovieDBQueryTask().execute(theMovieDBUrl);
    }

    public class TheMovieDBQueryTask extends AsyncTask<URL,Void,String>{

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String theMovieDBResult = null;
            try {
                theMovieDBResult = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return theMovieDBResult;
        }

        @Override
        protected void onPostExecute(String theMovieDBResult) {
            try {
                ArrayList<MovieData> testMovieArrayList = getMovieDataFromJSON(theMovieDBResult);
            } catch (JSONException e) {
                Log.i(TAG, "onPostExecute: ");
            }

        }
    }

}
