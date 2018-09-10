package com.quicksilver.moviesapp.validators;

import com.quicksilver.moviesapp.Constants;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.validators.base.Validator;

public class MovieValidator implements Validator<Movie> {
    @Override
    public boolean isValid(Movie object) {
        return object != null &&
                isTitleValid(object) &&
                isDescriptionValid(object) &&
                isCastValid(object);
    }
    private boolean isDescriptionValid(Movie object) {
        boolean isMinLengthValid = object.getDescription().length() >= Constants.MOVIE_DESCRIPTION_MIN_LENGTH;
        boolean isMaxLengthValid = object.getDescription().length() <= Constants.MOVIE_DESCRIPTION_MAX_LENGTH;

        if (!isMinLengthValid || !isMaxLengthValid) {
            throw new IllegalArgumentException("Invalid description");
        }

        return true;
    }

    private boolean isTitleValid(Movie object) {
        boolean isMinLengthValid = object.getTitle().length() >= Constants.MOVIE_TITLE_MIN_LENGTH;
        boolean isMaxLengthValid = object.getTitle().length() <= Constants.MOVIE_TITLE_MAX_LENGTH;

        if (!isMinLengthValid || !isMaxLengthValid) {
            throw new IllegalArgumentException("Invalid title");
        }

        return true;
    }

    private boolean isCastValid(Movie object) {
        boolean isMinLengthValid = object.getCast().length() >= Constants.MOVIE_CAST_MIN_LENGTH;
        boolean isMaxLengthValid = object.getCast().length() <= Constants.MOVIE_CAST_MAX_LENGTH;

        if (!isMinLengthValid || !isMaxLengthValid) {
            throw new IllegalArgumentException("Invalid cast");
        }

        return true;
    }
}
