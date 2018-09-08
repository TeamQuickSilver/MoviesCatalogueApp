package com.quicksilver.moviesapp.views.movieGenres;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

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

    private void presentMoviesToView(List<Movie> movies) {
        mView.showMovies(movies);
    }

    @Override
    public void filterMovies(String pattern) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<List<Movie>>) emitter -> {
            List<Movie> filteredMovies = mMoviesService.getFilteredMovies(pattern);
            emitter.onNext(filteredMovies);
            emitter.onComplete();
        })
            .subscribeOn(mSchedulerProvider.background())
            .observeOn(mSchedulerProvider.ui())
            .subscribe(this::presentMoviesToView, error -> mView.showError(error));
    }

    @Override
    public void selectMovie(Movie movie) {
        mView.showMovieDetails(movie);
    }
}
