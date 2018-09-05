package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.repositories.base.Repository;
import com.quicksilver.moviesapp.services.HttpMoviesService;
import com.quicksilver.moviesapp.services.base.MoviesService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public MoviesService moviesService(Repository<Movie> repository) {
        return new HttpMoviesService(repository);
    }
}
