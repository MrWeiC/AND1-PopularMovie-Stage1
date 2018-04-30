package io.weichen.popularmovie;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.weichen.popularmovie.utilities.NetworkUtils;

import static io.weichen.popularmovie.utilities.NetworkUtils.CATEGORY_POPULAR;
import static io.weichen.popularmovie.utilities.NetworkUtils.CATEGOry_TOP_RATED;
import static io.weichen.popularmovie.utilities.TheMovieDBJSONUtils.getMovieDataFromJSON;

public class MainActivity extends AppCompatActivity implements MovieAdapter.GridItemClickListener, AdapterView.OnItemSelectedListener {

    private final String TAG = MainActivity.class.getSimpleName();
    private String defaultSetting = CATEGORY_POPULAR;
    private final String MOVIE_DATA_TAG = "movie.data";

    private RecyclerView mMovieGridRecyclerView;
    private MovieAdapter mMovieAdapter;
    private Spinner mSpinner;
    private TextView mErrorMessageTextView;
    private ArrayList<MovieData> mMovieDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovieDataArrayList = new ArrayList<>();
        //Now start with the spinner
        mSpinner = findViewById(R.id.sp_movie_query_category);
        mMovieGridRecyclerView = findViewById(R.id.rv_movie_list);
        mMovieAdapter = new MovieAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mErrorMessageTextView = findViewById(R.id.tv_error_message);

        mMovieGridRecyclerView.setLayoutManager(layoutManager);
        mMovieGridRecyclerView.setHasFixedSize(true);
        mMovieGridRecyclerView.setAdapter(mMovieAdapter);

        // Check if there are network
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            // Spinner click listener
            mSpinner.setOnItemSelectedListener(this);

            // Spinner Drop down elements
            List<String> categories = new ArrayList<>();
            categories.add("By popular");
            categories.add("By top rated");

            // Creating adapter for spinner
            ArrayAdapter<String> spinnerDataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            spinnerDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            mSpinner.setAdapter(spinnerDataAdapter);

            makeTheMovieDBQuery(defaultSetting);
        } else {
            showErrorMessage();
        }
    }

    private void makeTheMovieDBQuery(String category) {
        URL theMovieDBUrl = NetworkUtils.buildMovieDataQueryUrl(category);

        new TheMovieDBQueryTask().execute(theMovieDBUrl);
    }

    @Override
    public void onGridItemClick(int index) {
        MovieData movie = mMovieDataArrayList.get(index);
        Intent movieDetailIntent = new Intent(this, MovieDetailsActivity.class);
        movieDetailIntent.putExtra(MOVIE_DATA_TAG, movie);
        startActivity(movieDetailIntent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0:
                defaultSetting = CATEGORY_POPULAR;
                break;
            case 1:
                defaultSetting = CATEGOry_TOP_RATED;
                break;
        }
        makeTheMovieDBQuery(defaultSetting);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public class TheMovieDBQueryTask extends AsyncTask<URL, Void, String> {

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
            if (theMovieDBResult != null) {
                try {
                    mMovieDataArrayList = getMovieDataFromJSON(theMovieDBResult);
                    mMovieAdapter.setMovieData(mMovieDataArrayList);
                } catch (JSONException e) {
                    Log.i(TAG, "onPostExecute: ");
                }
            }
        }
    }

    //Handle offline issue
    private void showErrorMessage() {
        mMovieGridRecyclerView.setVisibility(View.GONE);
        mSpinner.setVisibility(View.GONE);
        mErrorMessageTextView.setVisibility(View.VISIBLE);
    }
}
