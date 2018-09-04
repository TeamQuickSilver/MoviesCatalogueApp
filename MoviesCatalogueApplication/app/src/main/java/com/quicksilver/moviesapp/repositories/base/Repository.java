package com.quicksilver.moviesapp.repositories.base;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();

    T getById(int id);

    T add(T item);
}
