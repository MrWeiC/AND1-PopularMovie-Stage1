package io.weichen.popularmovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        TextView movieTextView = findViewById(R.id.tv_movie_details);

        Intent mIntent = getIntent();
        if(mIntent.hasExtra(Intent.EXTRA_TEXT)){
            String message = mIntent.getStringExtra(Intent.EXTRA_TEXT);
            movieTextView.setText(message);
        }
    }
}
