package com.quicksilver.moviesapp.models;

import java.io.Serializable;

public class Movie implements Serializable {
    public int id;
    public String title;
    public String imageUrl;
    public String cast;
    public String description;
    public String category;

    public Movie() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Movie(String title, String cast, String description, String category) {
        this.title = title;
        this.cast = cast;
        this.description = description;
        this.category = category;
    }

//    public Movie(int id, String title, String imageUrl, String cast, String description, String category) {
//        this.id = id;
//        this.title = title;
//        this.imageUrl = imageUrl;
//        this.cast = cast;
//        this.description = description;
//        this.category = category;
//    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
