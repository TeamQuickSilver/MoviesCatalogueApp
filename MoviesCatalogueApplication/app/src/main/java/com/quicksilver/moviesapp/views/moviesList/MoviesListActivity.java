package com.quicksilver.moviesapp.views.moviesList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;
import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MoviesListActivity extends BaseDrawerActivity implements MoviesListContracts.Navigator {

    public static final int IDENTIFIER = 1;
    private Toolbar mToolbar;

    @Inject
    MoviesListFragment mMoviesListFragment;

    @Inject
    MoviesListContracts.Presenter mMoviesListPresenter;

    @Inject
    MoviesListContracts.Presenter mMoviesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        ButterKnife.bind(this);

        mToolbar = findViewById(R.id.drawer_toolbar);

        mMoviesListFragment.setNavigator(this);
        mMoviesListFragment.setPresenter(mMoviesListPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mMoviesListFragment)
                .commit();
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }

    @Override
    public void navigateWith(Movie movie) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);

        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }
}
