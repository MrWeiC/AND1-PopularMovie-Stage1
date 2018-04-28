package io.weichen.popularmovie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import io.weichen.popularmovie.utilities.NetworkUtils;

import static io.weichen.popularmovie.utilities.NetworkUtils.CATEGORY_POPULAR;

public class MainActivity extends AppCompatActivity {

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
            test.setText(theMovieDBResult);
        }
    }


}
