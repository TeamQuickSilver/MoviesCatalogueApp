package com.quicksilver.moviesapp.diconfig;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentManagerModule {
    @Provides
    FragmentManager fm() {
        FragmentActivity fragmentActivity = new FragmentActivity();
        return fragmentActivity.getSupportFragmentManager();
    }
}
