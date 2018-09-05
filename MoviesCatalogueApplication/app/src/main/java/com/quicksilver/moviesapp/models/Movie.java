package com.quicksilver.moviesapp.models;

public class Movie {
    public int id;
    public String name;
    public String imageUrl;
    public String cast;
    public String description;

    public Movie() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Movie(int id, String name, String imageUrl, String cast, String description) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.cast = cast;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
