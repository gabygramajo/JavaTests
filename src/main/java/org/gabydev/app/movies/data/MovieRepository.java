package org.gabydev.app.movies.data;

import org.gabydev.app.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);

}
