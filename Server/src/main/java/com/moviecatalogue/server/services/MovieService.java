package com.moviecatalogue.server.services;

import com.moviecatalogue.server.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements BaseService<Movie> {
    private final Repository<Movie> repository;

    @Autowired
    public MovieService(Repository<Movie> repository) {
        this.repository = repository;
    }

    @Override
    public List<Movie> getAll() {
        return null;
    }

    @Override
    public Movie getById(int id) {
        return null;
    }

    @Override
    public Movie add(Movie object) {
        return null;
    }
}
