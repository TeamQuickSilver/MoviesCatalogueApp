package com.quicksilver.moviesapp.models;

import java.io.Serializable;

public class Movie implements Serializable {
    public int id;
    public String title;
    public byte[] imageBytes;
    public String cast;
    public String description;
    public String category;
    public float rating;

    public Movie() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Movie(String title, String cast, String description, String category, byte[] imageBytes) {
        this.title = title;
        this.cast = cast;
        this.description = description;
        this.category = category;
        this.imageBytes = imageBytes;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getCast() {
        return cast;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
