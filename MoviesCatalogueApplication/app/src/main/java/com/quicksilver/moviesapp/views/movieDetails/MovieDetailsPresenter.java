package com.quicksilver.moviesapp.views.movieDetails;


import com.quicksilver.moviesapp.async.base.SchedulerProvider;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.services.base.MoviesService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MovieDetailsPresenter implements MovieDetailsContracts.Presenter {
    private MovieDetailsContracts.View mView;
    private MoviesService mMovieService;
    private SchedulerProvider mSchedulerProvider;

    @Inject
    public MovieDetailsPresenter(MoviesService mMovieService, SchedulerProvider mSchedulerProvider) {
        this.mMovieService = mMovieService;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(MovieDetailsContracts.View view) {
        this.mView = view;
    }

    @Override
    public void loadMovieId(int id) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<Movie>) emitter -> {
            Movie movie = mMovieService.getDetailById(id);
            emitter.onNext(movie);
            emitter.onComplete();
        })
            .subscribeOn(mSchedulerProvider.background())
            .observeOn(mSchedulerProvider.ui())
            .subscribe(m -> mView.showMovie(m), error -> mView.showError(error));
    }
}
