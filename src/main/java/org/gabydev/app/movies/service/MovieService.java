package org.gabydev.app.movies.service;

import org.gabydev.app.movies.data.MovieRepository;
import org.gabydev.app.movies.model.Genre;
import org.gabydev.app.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> fintMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> fintMoviesByLength(int lentgh) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= lentgh).collect(Collectors.toList());
    }
}
