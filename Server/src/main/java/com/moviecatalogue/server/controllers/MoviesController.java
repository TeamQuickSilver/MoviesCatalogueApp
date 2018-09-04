package com.moviecatalogue.server.controllers;

import com.moviecatalogue.server.models.Movie;
import com.moviecatalogue.server.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MoviesController {

    private BaseService<Movie> service;

    @Autowired
    public MoviesController(BaseService<Movie> service) {
        this.service = service;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return service.getAll();
    }

    @GetMapping("movies/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return service.getById(id);
    }
}
