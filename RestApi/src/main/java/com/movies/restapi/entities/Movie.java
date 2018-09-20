package com.movies.restapi.entities;


import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageBytes;
    private String cast;
    @Column(columnDefinition = "VARCHAR(1000)")
    private String description;
    private String category;
    private float rating;

    public Movie() {

    }

    public Movie(int id, String title, String imageUrl, String cast, String description, String category, byte[] imageBytes) {
        this.id = id;
        this.title = title;
        this.imageBytes = imageBytes;
        this.cast = cast;
        this.description = description;
        this.category = category;
        this.rating = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
