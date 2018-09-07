package com.quicksilver.moviesapp.views.movieCreate;

import com.quicksilver.moviesapp.models.Movie;

public interface MovieCreateContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showLoading();

        void hideLoading();

        void setNavigator(Navigator navigator);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void addMovie(Movie movie);
    }

    interface Navigator {
        void navigateToHome();
    }
}
