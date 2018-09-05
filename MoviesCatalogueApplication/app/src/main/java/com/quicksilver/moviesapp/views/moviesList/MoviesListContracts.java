package com.quicksilver.moviesapp.views.moviesList;

import com.quicksilver.moviesapp.models.Movie;

import java.util.List;

public interface MoviesListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showMovies(List<Movie> movies);

        void showLoading();

        void hideLoading();

        void showMovieDetails(Movie movie);
    }

    interface Presenter {
        void subscribe(View view);

        void loadMovies();

        void filterMovies(Movie movie);

        void selectMovie(Movie movie);
    }

    interface  Navigator {
        void navigateWith(Movie movie);
    }
}
