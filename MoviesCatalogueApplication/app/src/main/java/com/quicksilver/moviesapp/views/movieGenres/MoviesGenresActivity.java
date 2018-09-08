package com.quicksilver.moviesapp.views.movieGenres;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
<<<<<<< HEAD
import android.util.Log;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;

public class MoviesGenresActivity extends BaseDrawerActivity {
=======

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;
import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsActivity;

import javax.inject.Inject;

public class MoviesGenresActivity extends BaseDrawerActivity implements MovieGenreContracts.Navigator {
>>>>>>> ff0f99ccf838da74c240a10de70845af24564f9d
    public static final int IDENTIFIER = 4;

//    @Inject
//    ActionGenreFragment mActionGenreFragment;
//
//    @Inject
//    ComedyGenreFragment mComedyGenreFragment;
//
//    @Inject
//    CrimeGenreFragment mCrimeGenreFragment;
//
//    @Inject
//    HorrorGenreFragment mHorrorGenreFragment;
//
//    @Inject
//    MovieGenreContracts.Presenter mMovieGenrePresenter;

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_genres);


        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        setSupportActionBar(getDrawerToolbar());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ActionGenreFragment(), "Action");
        adapter.addFragment(new ComedyGenreFragment(), "Comedy");
        adapter.addFragment(new CrimeGenreFragment(), "Crime");
        adapter.addFragment(new HorrorGenreFragment(), "Horror");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }
<<<<<<< HEAD
=======

    @Override
    public void navigateWith(Movie movie) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);

        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }
>>>>>>> ff0f99ccf838da74c240a10de70845af24564f9d
}
