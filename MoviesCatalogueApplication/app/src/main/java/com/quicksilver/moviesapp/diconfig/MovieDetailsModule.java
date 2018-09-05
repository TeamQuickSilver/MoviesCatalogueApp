package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MovieDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract MovieDetailsFragment movieDetailsFragment();

//    @ActivityScoped
//    @Binds
//    detailsPresenter here
}
