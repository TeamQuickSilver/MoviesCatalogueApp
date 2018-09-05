package com.moviecatalogue.server.repositories;

import com.moviecatalogue.server.models.Movie;
import com.moviecatalogue.server.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesRepository implements BaseRepository<Movie> {
    private List<Movie> movies;

    public MoviesRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie(1, "Fast and furious",
                "https://resizing.flixster.com/2SyVDeb2YP_1eQ3DgIi9WSNKIug=/206x305/v1.bTsxMTE2ODg2OTtqOzE3ODU5OzEyMDA7ODAwOzEyMDA",
                "Vin Diesel",
                "No description",  "No description"));

        movies.add(new Movie(2, "Titanic",
                "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_.jpg",
                "Leonardo Di Caprio",
                "No description",  "No description"));
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
        movies.add(object);
        return object;
    }
}
