package com.quicksilver.moviesapp.services.base;

import com.quicksilver.moviesapp.models.Movie;

import java.util.List;

public interface MoviesService {
    List<Movie> getAllMovies();

    Movie getDetailById(int id);
}
