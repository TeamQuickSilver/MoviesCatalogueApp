package com.quicksilver.moviesapp.validators;

import com.quicksilver.moviesapp.Constants;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.validators.base.Validator;

public class MovieValidator implements Validator<Movie> {
    @Override
    public boolean isValid(Movie object) {
        return object != null &&
                isTitleValid(object) &&
                isDescriptionValid(object);
    }
    private boolean isDescriptionValid(Movie object) {
        return object.getDescription().length() >= Constants.MOVIE_DESCRIPTION_MIN_LENGTH &&
                object.getDescription().length() <= Constants.MOVIE_DESCRIPTION_MAX_LENGTH;
    }

    private boolean isTitleValid(Movie object) {
        return object.getTitle().length() >= Constants.MOVIE_TITLE_MIN_LENGTH &&
                object.getTitle().length() <= Constants.MOVIE_TITLE_MAX_LENGTH;
    }
}
