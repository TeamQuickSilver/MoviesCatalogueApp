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
                "No description", "No description"));

        movies.add(new Movie(2, "Titanic",
                "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_.jpg",
                "Leonardo Di Caprio",
                "No description", "No description"));
        movies.add(new Movie(3, "GoodFellas",
                "https://vignette.wikia.nocookie.net/cinemorgue/images/d/d6/Goodfellas-56dc074f56dd7.jpg/revision/latest?cb=20160830143345" ,
                " Robert De Niro",
                "No description", "No description"));
        movies.add(new Movie(4, "The Godfather",
                "https://static.posters.cz/image/1300/%D0%BF%D0%BB%D0%B0%D0%BA%D0%B0%D1%82/the-godfather-colour-cat-i8602.jpg",
                "Marlon Brando",
                "No description", "No description"));
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
    public Movie add(Movie movie) {
        movie.setId(movies.size());
        movie.setImageUrl("https://cdn20.patchcdn.com/users/22949620/20180504/071619/styles/T800x600/public/processed_images/jag_cz_movie_theater_retro_shutterstock_594132752-1525432478-9343.jpg");

        movies.add(movie);
        return movie;
    }
}
