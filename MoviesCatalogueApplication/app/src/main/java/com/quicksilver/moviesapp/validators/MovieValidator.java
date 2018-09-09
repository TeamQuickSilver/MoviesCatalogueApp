package com.quicksilver.moviesapp.validators;

import com.quicksilver.moviesapp.Constants;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.validators.base.Validator;

public class MovieValidator implements Validator<Movie> {
    @Override
    public boolean isValid(Movie object) {
        return object != null &&
                isNameValid(object) &&
                isDescriptionValid(object);
    }
    private boolean isDescriptionValid(Movie object) {
        return object.getDescription().length() >= Constants.MOVIE_DESCRIPTION_MIN_LENGTH &&
                object.getDescription().length() <= Constants.MOVIE_DESCRIPTION_MAX_LENGTH;
    }

    private boolean isNameValid(Movie object) {
        return object.getTitle().length() >= Constants.MOVIE_NAME_MIN_LENGTH &&
                object.getTitle().length() <= Constants.MOVIE_NAME_MAX_LENGTH;
    }
}
