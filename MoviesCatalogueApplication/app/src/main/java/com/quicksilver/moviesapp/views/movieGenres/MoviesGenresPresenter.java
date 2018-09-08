package com.quicksilver.moviesapp.views.movieGenres;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import java.util.List;

import javax.inject.Inject;

public class MoviesGenresPresenter implements MovieGenreContracts.Presenter {

    private MovieGenreContracts.View mView;
    private final MoviesService mMoviesService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    public MoviesGenresPresenter(MoviesService moviesService, SchedulerProvider schedulerProvider) {
        mMoviesService = moviesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(MovieGenreContracts.View view) {
        mView = view;
    }

    @Override
    public void loadMovies() {

    }

    private void presentMoviesToView(List<Movie> movies) {
        mView.showMovies(movies);
    }

    @Override
    public void filterMovies(String pattern) {

    }

    @Override
    public void selectMovie(Movie movie) {
        mView.showMovieDetails(movie);
    }
}
