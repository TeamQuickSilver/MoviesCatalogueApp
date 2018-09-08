package com.quicksilver.moviesapp.views.movieGenres;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;
import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesGenresActivity extends BaseDrawerActivity implements MovieGenreContracts.Navigator {
    public static final int IDENTIFIER = 4;

    @Inject
    ActionGenreFragment mActionGenreFragment;

    @Inject
    ComedyGenreFragment mComedyGenreFragment;

    @Inject
    CrimeGenreFragment mCrimeGenreFragment;

    @Inject
    HorrorGenreFragment mHorrorGenreFragment;

    @Inject
    MovieGenreContracts.Presenter mMovieGenrePresenter;

    @Inject
    SectionsPageAdapter mSectionsPageAdapter;

    @BindView(R.id.container)
    ViewPager mViewPager;

    @BindView(R.id.tabs)
    TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_genres);

        ButterKnife.bind(this);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mActionGenreFragment.setPresenter(mMovieGenrePresenter);
        mComedyGenreFragment.setPresenter(mMovieGenrePresenter);
        mCrimeGenreFragment.setPresenter(mMovieGenrePresenter);
        mHorrorGenreFragment.setPresenter(mMovieGenrePresenter);

        setSupportActionBar(getDrawerToolbar());

        // Set up the ViewPager with the sections adapter.
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        mSectionsPageAdapter.addFragment(mActionGenreFragment, ActionGenreFragment.TITLE);
        mSectionsPageAdapter.addFragment(mComedyGenreFragment, ComedyGenreFragment.TITLE);
        mSectionsPageAdapter.addFragment(mCrimeGenreFragment, CrimeGenreFragment.TITLE);
        mSectionsPageAdapter.addFragment(mHorrorGenreFragment, HorrorGenreFragment.TITLE);
        viewPager.setAdapter(mSectionsPageAdapter);
    }

    @Override
    protected int getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Movie movie) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);

        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }
}
