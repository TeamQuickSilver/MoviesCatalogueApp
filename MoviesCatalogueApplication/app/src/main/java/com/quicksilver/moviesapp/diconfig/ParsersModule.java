package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.parsers.GsonJsonParser;
import com.quicksilver.moviesapp.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<Movie> movieJsonParser() {
        return new GsonJsonParser<>(Movie.class, Movie[].class);
    }
}
