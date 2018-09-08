package com.quicksilver.moviesapp.views.movieHome;

import android.os.Bundle;
import android.app.Activity;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.BaseDrawerActivity;

public class HomeActivity extends Activity {

    public static final int IDENTIFIER = 1;

    private HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHomeFragment = HomeFragment.newInstance();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mHomeFragment)
                .commit();
    }

//    @Override
//    protected int getIdentifier() {
//        return IDENTIFIER;
//    }
}
