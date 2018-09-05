package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.views.movieDetails.MovieDetailsActivity;
import com.quicksilver.moviesapp.views.moviesList.MoviesListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MoviesListModule.class)
    abstract MoviesListActivity moviesListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = MovieDetailsModule.class)
    abstract MovieDetailsActivity movieDetailsActivity();
}
