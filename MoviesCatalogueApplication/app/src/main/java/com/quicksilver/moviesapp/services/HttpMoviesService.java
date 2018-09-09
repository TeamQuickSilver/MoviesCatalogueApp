package com.quicksilver.moviesapp.services;

import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.repositories.base.Repository;
import com.quicksilver.moviesapp.services.base.MoviesService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HttpMoviesService implements MoviesService{
    private static final int TOP_MOVIES = 4;
    private Repository<Movie> mMoviesRepository;

    public HttpMoviesService(Repository<Movie> moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    public List<Movie> getAllMovies() throws IOException {
        return mMoviesRepository.getAll();
    }

    @Override
    public Movie getDetailById(int id) throws IOException {
        return mMoviesRepository.getById(id);
    }

    @Override
    public List<Movie> getFilteredMovies(String pattern) throws IOException {
        List<Movie> movies = getAllMovies().stream()
                .filter(movie -> movie.getCategory().equals(pattern)).collect(Collectors.toList());

        return movies;
    }

    @Override
    public Movie createMovie(Movie movie) throws IOException {
        return mMoviesRepository.add(movie);
    }

    @Override
    public List<Movie> getLatestMovies() throws IOException {
        List<Movie> allMovies = getAllMovies();
        List<Movie> latestMovies = new ArrayList<>();

        int endIndex = allMovies.size() - TOP_MOVIES;
        for (int i = allMovies.size() - 1; i >= endIndex; i--) {
            latestMovies.add(allMovies.get(i));
        }

        return latestMovies;
    }
}
