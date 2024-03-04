package org.gabydev.app.movies.service;

import org.gabydev.app.movies.data.MovieRepository;
import org.gabydev.app.movies.model.Genre;
import org.gabydev.app.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", "Christopher Nolan", 152, Genre.ACTION),
                        new Movie(2, "Memento", "Christopher Nolan", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Marty", "Peter Farrelly", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", "J. J. Abrams", 112, Genre.THRILLER),
                        new Movie(5, "Scream", "Wes Craven", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", "Chris Columbus", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", "The Wachowskis", 136, Genre.ACTION),
                        new Movie(8, "Superman Returns", "Bryan Singer", 154, Genre.ACTION),
                        new Movie(9, "Spider-Man: Far from Home", "Jon Watts", 129, Genre.ACTION)
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }


    @Test
    public void return_movies_by_lentgh() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);

        assertThat(getMovieIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void return_movie_by_name() {
        Collection<Movie> movies = movieService.findMovieByName("Super");

        assertThat(getMovieIds(movies), is(Arrays.asList(4, 8)));
    }

    @Test
    public void return_movie_by_name_lower_case() {
        Collection<Movie> movies = movieService.findMovieByName("home");

        assertThat(getMovieIds(movies), is(Arrays.asList(6, 9)));
    }

    @Test
    public void return_movie_by_name_upper_case() {
        Collection<Movie> movies = movieService.findMovieByName("HOME");

        assertThat(getMovieIds(movies), is(Arrays.asList(6, 9)));
    }

    @Test
    public void return_movie_by_director() {
        Collection<Movie> movies = movieService.findMovieByDirector("Christopher Nolan");

        assertThat(getMovieIds(movies), is(Arrays.asList(1, 2)));
    }

    private static List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}