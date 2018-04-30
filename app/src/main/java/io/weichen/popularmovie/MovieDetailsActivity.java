package io.weichen.popularmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.weichen.popularmovie.utilities.NetworkUtils;

public class MovieDetailsActivity extends AppCompatActivity {
    private final String MOVIE_DATA_TAG = "movie.data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        TextView movieTitleTextView = findViewById(R.id.tv_movie_details_title);
        TextView movieRatingTextView = findViewById(R.id.tv_movie_details_rating);
        TextView movieReleaseDateTextView = findViewById(R.id.tv_movie_details_release_date);
        TextView movieOverviewTextView = findViewById(R.id.tv_movie_details_overview);
        ImageView moviePosterImageView = findViewById(R.id.iv_movie_details_poster);

        Intent mIntent = getIntent();
        if (mIntent.hasExtra(MOVIE_DATA_TAG)) {
            MovieData mMovieData = mIntent.getExtras().getParcelable(MOVIE_DATA_TAG);
            //This part of UI will get major update in the stage 2
            movieTitleTextView.setText(mMovieData.getOriginalTitle());
            movieRatingTextView.setText("Rating:" + mMovieData.getUserRating());
            movieReleaseDateTextView.setText("Release on " + mMovieData.getReleaseDate());
            movieOverviewTextView.setText("OverView: \n" + mMovieData.getOverview());

            String posterURL = NetworkUtils.buildPosterPathURL(mMovieData.getMoviePosterImageThumbnail()).toString();
            Picasso.get().load(posterURL).into(moviePosterImageView);
        }
    }
}
