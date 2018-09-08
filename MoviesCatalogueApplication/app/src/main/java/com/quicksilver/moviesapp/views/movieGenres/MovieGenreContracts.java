package com.quicksilver.moviesapp.views.movieGenres;

import com.quicksilver.moviesapp.models.Movie;

import java.util.List;

public interface MovieGenreContracts {
    interface View {
        void setPresenter(MovieGenreContracts.Presenter presenter);

        void showMovies(List<Movie> movies);

        void setNavigator(MovieGenreContracts.Navigator navigator);

        void showMovieDetails(Movie movie);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(MovieGenreContracts.View view);

        void filterMovies(String pattern);

        void selectMovie(Movie movie);
    }

    interface Navigator {
        void navigateWith(Movie movie);
    }
}
