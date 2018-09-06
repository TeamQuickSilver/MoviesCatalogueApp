package com.quicksilver.moviesapp.views.movieCreate;

import com.quicksilver.moviesapp.models.Movie;

public interface MovieCreateContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showForm();

        void showCreatedMovie(Movie movie);

        void showLoading();

        void hideLoading();

        void setNavigator(Navigator navigator);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void selectMovie(Movie movie);

        void addMovie(Movie movie);
    }

    interface Navigator {
        void navigateWith(Movie movie);
    }
}
