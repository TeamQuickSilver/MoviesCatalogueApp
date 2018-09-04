package com.quicksilver.moviesapp.services.base;

import com.quicksilver.moviesapp.models.Movie;

import java.io.IOException;
import java.util.List;

public interface MoviesService {
    List<Movie> getAllMovies() throws IOException;

    Movie getDetailById(int id) throws IOException;
}
