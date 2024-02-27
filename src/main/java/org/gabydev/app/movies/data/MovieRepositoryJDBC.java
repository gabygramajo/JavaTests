package org.gabydev.app.movies.data;

import org.gabydev.app.movies.model.Genre;
import org.gabydev.app.movies.model.Movie;
import org.springframework.jdbc.core.*;

import java.util.Collection;

public class MovieRepositoryJDBC implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name, minutes, genre) values (?,?,?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }


    // utilizando el jdbc de spring framework para traer movies de la BD
    private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre"))
    );

}
