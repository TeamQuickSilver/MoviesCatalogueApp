package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.http.HttpRequester;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.parsers.base.JsonParser;
import com.quicksilver.moviesapp.repositories.HttpRepository;
import com.quicksilver.moviesapp.repositories.base.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<Movie> movieRepository(HttpRequester httpRequester, JsonParser<Movie> jsonParser, String serverUrl) {
        String url = serverUrl + "/movies";
        return new HttpRepository<>(httpRequester, jsonParser, url);
    }
}
