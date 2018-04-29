package io.weichen.popularmovie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    private RecyclerView mMovieGridRecyclerView;
    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMovieAdapter = new MovieAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        mMovieGridRecyclerView = (RecyclerView) findViewById(R.id.rv_movie_list);
        mMovieGridRecyclerView.setLayoutManager(layoutManager);
        mMovieGridRecyclerView.setHasFixedSize(true);

        mMovieGridRecyclerView.setAdapter(mMovieAdapter);
        //TODO
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
            if(theMovieDBResult != null) {
                try {
                    ArrayList<MovieData> mMovieDataArrayList = getMovieDataFromJSON(theMovieDBResult);
                    mMovieAdapter.setMovieData(mMovieDataArrayList);
                } catch (JSONException e) {
                    Log.i(TAG, "onPostExecute: ");
                }
            }
            //TODO:
        }
    }

}
