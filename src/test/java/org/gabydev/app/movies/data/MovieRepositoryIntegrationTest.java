package org.gabydev.app.movies.data;

import org.gabydev.app.movies.model.Genre;
import org.gabydev.app.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private static MovieRepositoryJDBC movieRepository;
    public static DataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        // creando un BD en memoria y la conexión
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        // ejecutar el script sql
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        // creando el jdbcTemplate para el repositorio pueda conectarse a la BD
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        movieRepository = new MovieRepositoryJDBC(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @Test
    public void insert_a_movie() {

        Movie movie = new Movie("Super 8", 113, Genre.THRILLER);

        movieRepository.saveOrUpdate(movie);

        Movie movieFromDb = movieRepository.findById(4);

        assertThat(movieFromDb, is(new Movie(4,"Super 8", 113, Genre.THRILLER)));
    }

    @After
    public void tearDown() throws Exception {
        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough for mem db
    }
}