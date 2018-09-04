package com.quicksilver.moviesapp.services;

import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.repositories.base.Repository;
import com.quicksilver.moviesapp.services.base.MoviesService;

import java.util.List;

public class HttpMoviesService implements MoviesService{
    private Repository<Movie> mMoviesRepository;

    public HttpMoviesService(Repository<Movie> moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return mMoviesRepository.getAll();
    }

    @Override
    public Movie getDetailById(int id) {
        return mMoviesRepository.getById(id);
    }
}
