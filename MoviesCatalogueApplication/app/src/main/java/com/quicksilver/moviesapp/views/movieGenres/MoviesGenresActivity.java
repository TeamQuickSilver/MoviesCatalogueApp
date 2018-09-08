package com.quicksilver.moviesapp.views.movieGenres;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.quicksilver.moviesapp.R;

public class MoviesGenresActivity extends AppCompatActivity {
    public static final int IDENTIFIER = 4;

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_genres);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

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

}
