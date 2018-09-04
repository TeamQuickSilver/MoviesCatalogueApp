package com.moviecatalogue.server.models;

public class Movie {
    private int id;
    private String name;
    private String imageUrl;
    private String cast;
    private String description;

    public Movie() {
    }

    public Movie(int id, String name, String imageUrl, String cast, String description) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.cast = cast;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCast() {
        return this.cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
