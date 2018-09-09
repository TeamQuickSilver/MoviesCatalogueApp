package com.quicksilver.moviesapp.views.movieDetails;

import com.quicksilver.moviesapp.models.Movie;

public interface MovieDetailsContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showMovie(Movie movie);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void loadMovieId(int id);

        void selectMovie(Movie mMovie);
    }
}
