package io.weichen.popularmovie;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements MovieAdapter.GridItemClickListener{

    private final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mMovieGridRecyclerView;
    private MovieAdapter mMovieAdapter;
    private ArrayList<MovieData> mMovieDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovieDataArrayList = new ArrayList<>();

        mMovieAdapter = new MovieAdapter(this);
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

    @Override
    public void onGridItemClick(int index) {
        String movieTitle = mMovieDataArrayList.get(index).getOriginalTitle();
        Intent movieDetailIntent = new Intent(this, MovieDetailsActivity.class);
        movieDetailIntent.putExtra(Intent.EXTRA_TEXT, movieTitle);
        startActivity(movieDetailIntent);
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
                    mMovieDataArrayList = getMovieDataFromJSON(theMovieDBResult);
                    mMovieAdapter.setMovieData(mMovieDataArrayList);
                } catch (JSONException e) {
                    Log.i(TAG, "onPostExecute: ");
                }
            }
            //TODO:
        }
    }

}
