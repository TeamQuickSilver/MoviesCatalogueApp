package com.movies.restapi.controllers;

import com.movies.restapi.entities.Movie;
import com.movies.restapi.services.movies.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getById(id);
    }

    @PostMapping
    public Movie addMovie(Movie movie) {
        return movieService.add(movie);
    }

    @PutMapping
    public Movie updateMovie(int id, Movie movie) {
        return movieService.update(id, movie);
    }
}
