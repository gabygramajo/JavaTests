package org.gabydev.app.movies.model;

import java.util.Objects;

public class Movie {
    private Integer id;
    private String name;
    private String director;
    private int minutes;
    private Genre genre;

    public Movie(String name, String director, int minutes, Genre genre) {
        this(null, name, director, minutes, genre);
    }

    public Movie(Integer id, String name, String director, int minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", minutes=" + minutes +
                ", genre=" + genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return minutes == movie.minutes && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(director, movie.director) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, director, minutes, genre);
    }
}
