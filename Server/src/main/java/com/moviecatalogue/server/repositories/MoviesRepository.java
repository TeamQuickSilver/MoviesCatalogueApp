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
                "https://vignette.wikia.nocookie.net/fastandfurious/images/0/04/" +
                        "The_Fast_and_the_Furious_%28DVD_Cover%29.jpeg/revision/latest?cb=20150501043627",
                "Vin Diesel, Paul Walker, Michelle Rodriguez",
                "The Fast and the Furious is an American media franchise based on a series of action" +
                        " films that is largely concerned with illegal street racing, heists and espionage, " +
                        "and includes material in various other media that " +
                        "depicts characters and situations from the films. ", "Action"));

        movies.add(new Movie(2, "The Conjuring",
                "https://upload.wikimedia.org/wikipedia/en/1/1f/Conjuring_poster.jpg",
                "Patrick Wilson, Vera Farmiga, Ron Livingston",
                "The Conjuring is a 2013 American supernatural horror film directed by James Wan " +
                        "and written by Chad Hayes and Carey W. Hayes. It is the first installment in The Conjuring" +
                        " Universe.[3] Patrick Wilson and Vera Farmiga star as Ed and Lorraine Warren, paranormal " +
                        "investigators and authors associated with prominent cases of haunting.", "Horror"));

        movies.add(new Movie(3, "GoodFellas",
                "https://upload.wikimedia.org/wikipedia/en/7/7b/Goodfellas.jpg" ,
                " Robert De Niro, Ray Liotta, Joe Pesci",
                "Goodfellas (stylized as GoodFellas) is a 1990 American crime film directed by Martin" +
                        " Scorsese. It is an adaptation of the 1986 non-fiction book Wiseguy by Nicholas Pileggi, " +
                        "who co-wrote the screenplay with Scorsese. The film narrates the rise and fall of mob " +
                        "associate Henry Hill and his friends and family from 1955 to 1980. ", "Crime"));

        movies.add(new Movie(4, "The Godfather",
                "https://static.posters.cz/image/1300/%D0%BF%D0%BB%D0%B0%D0%BA%D0%B0%D1%82/the-godfather-colour-cat-i8602.jpg",
                "Marlon Brando, Al Pacino, James Caan",
                "The Godfather is a 1972 American crime film directed by Francis Ford Coppola and produced " +
                        "by Albert S. Ruddy, based on Mario Puzo's best-selling novel of the same name. It stars Marlon" +
                        " Brando and Al Pacino as the leaders of a fictional New York crime family. The story, " +
                        "spanning 1945 to 1955, chronicles the family under the patriarch Vito Corleone (Brando), " +
                        "focusing on the transformation of Michael Corleone (Pacino) from reluctant family outsider to " +
                        "ruthless mafia boss. ", "Crime"));

        movies.add(new Movie(5, "Rush Hour",
                "https://upload.wikimedia.org/wikipedia/en/thumb/5/55/Rush_hour_ver2.jpg/220px-Rush_hour_ver2.jpg",
                "Jackie Chan, Chris Tucker, Ken Leung",
                "Rush Hour is a 1998 American action comedy film directed by Brett Ratner and written by Jim Kouf " +
                        "and Ross LaManna from a story by LaManna. It stars Jackie Chan and Chris Tucker as mismatched" +
                        " police officers who must rescue the Chinese consul's kidnapped daughter. Tom Wilkinson, Chris " +
                        "Penn, and Elizabeth Peña play supporting roles. Released on September 18, 1998, the film " +
                        "grossed over $244 million worldwide. The film's success led to two sequels: Rush Hour 2 (2001)" +
                        "and Rush Hour 3 (2007).", "Comedy"));

        movies.add(new Movie(6, "The Italian Job",
                "https://images-na.ssl-images-amazon.com/images/I/71-ErxbNPKL._SY445_.jpg",
                "Donald Sutherland, Mark Wahlberg, Edward Norton",
                "The Italian Job is a 2003 American heist film directed by F. Gary Gray, written by Wayne" +
                        " and Donna Powers and produced by Donald DeLine. The film stars Mark Wahlberg, Charlize " +
                        "Theron, Edward Norton, Jason Statham, Seth Green, Mos Def and Donald Sutherland. It is" +
                        " an American remake of the 1969 British film of the same name, and is about a team of thieves" +
                        " who plan to steal gold from a former associate who double-crossed them.", "Action"));
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
        movie.setId(movies.size() + 1);
        movie.setImageUrl("https://cdn20.patchcdn.com/users/22949620/20180504/071619/styles/T800x600/public/processed_images/jag_cz_movie_theater_retro_shutterstock_594132752-1525432478-9343.jpg");

        movies.add(movie);
        return movie;
    }
}
