package com.quicksilver.moviesapp.views.movieList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.quicksilver.moviesapp.BaseDrawerActivity;
import com.quicksilver.moviesapp.R;

public class MoviesListActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 1;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        setSupportActionBar(getToolbar());
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }
}
