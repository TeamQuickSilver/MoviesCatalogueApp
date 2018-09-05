package com.quicksilver.moviesapp.views.movieDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.quicksilver.moviesapp.R;

import javax.inject.Inject;

public class MovieDetailsActivity extends AppCompatActivity {

    @Inject
    MovieDetailsFragment movieDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
    }
}
