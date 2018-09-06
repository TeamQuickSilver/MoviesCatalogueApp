package com.quicksilver.moviesapp.views.movieCreate;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;

import javax.inject.Inject;

public class MoviesCreateActivity extends BaseDrawerActivity implements MovieCreateContracts.Navigator{
    public static final int IDENTIFIER = 3;
    private Toolbar mToolbar;

    @Inject
    MoviesCreateFragment mMoviesCreateFragment;

    @Inject
    MovieCreateContracts.Presenter mMoviesCreatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_create);

        mToolbar = findViewById(R.id.drawer_toolbar);

        mMoviesCreateFragment.setNavigator(this);
        mMoviesCreateFragment.setPresenter(mMoviesCreatePresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mMoviesCreateFragment)
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

    }
}
