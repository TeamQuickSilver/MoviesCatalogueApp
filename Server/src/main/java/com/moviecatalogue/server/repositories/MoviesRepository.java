package com.moviecatalogue.server.repositories;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class MoviesRepository implements BaseRepository<Movie> {
    private List<Movie> movies;

    public MoviesRepository() {
        movies = new ArrayList<>();
    }

    @Override
    public List<Movie> getAll() {
        return movies;
    }

    @Override
    public Movie getById(int id) {
        return movies.get(id);
    }

    @Override
    public Movie add(Movie object) {
        return movies.add(object);
    }
}
