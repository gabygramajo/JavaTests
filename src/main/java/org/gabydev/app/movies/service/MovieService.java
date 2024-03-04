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

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int lentgh) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= lentgh).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByName(String name) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase()
                        .contains(name.toLowerCase())
                ).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByDirector(String director) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase()
                        .contains(director.toLowerCase())
                ).collect(Collectors.toList());
    }
}
