package com.quicksilver.moviesapp.models;

import java.io.Serializable;

public class Movie implements Serializable {
    public int id;
    public String name;
    public String imageUrl;
    public String cast;
    public String description;
    public String categories;

    public Movie() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Movie(int id, String name, String imageUrl, String cast, String description, String categories) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.cast = cast;
        this.description = description;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
