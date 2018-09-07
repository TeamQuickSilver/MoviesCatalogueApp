package com.quicksilver.moviesapp.views.movieCreate;

import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MoviesCreatePresenter implements MovieCreateContracts.Presenter {
    private final MoviesService mMoviesService;
    private final SchedulerProvider mSchedulerProvider;
    private MovieCreateContracts.View mView;

    @Inject
    public MoviesCreatePresenter(MoviesService moviesService, SchedulerProvider schedulerProvider) {
        this.mMoviesService = moviesService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(MovieCreateContracts.View view) {
        this.mView = view;
    }

    @Override
    public void addMovie(Movie movie) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<Movie>) emitter -> {
            mMoviesService.createMovie(movie);
            emitter.onNext(movie);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(m -> mView.navigateToHome(), error -> mView.showError(error));
    }
}
