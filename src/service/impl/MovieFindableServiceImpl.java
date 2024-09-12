package service.impl;

import module.Actor;
import module.Producer;
import service.MovieFindableService;
import database.Database;
import module.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieFindableServiceImpl implements MovieFindableService {
    @Override
    public List<Movie> getAllMovies() {
        return Database.movies;
    }

    @Override
    public List<Movie> findMovieByFullTitleOrPartTitle(String title) {
        List<Movie> newMovies = new ArrayList<>();
        for (Movie movie : Database.movies) {
            if (movie.getTitle().contains(title)) {
                newMovies.add(movie);
            }
        }
        return newMovies;
    }

    @Override
    public List<Movie> findMovieByActorName(String actorName) {
        List<Movie> newMovies = new ArrayList<>();
        for (Movie movie : Database.movies) {
            for (Actor actor : movie.getActors()) {
                if(actor.getActorFullName().contains(actorName)) {
                    newMovies.add(movie);
                }
            }
        }
        return newMovies;
    }

    @Override
    public List<Movie> findMovieByYear(int year) {
        List<Movie> newMovies = new ArrayList<>();
        for (Movie movie : Database.movies) {
            if (movie.getYear().getYear() == year) {
                newMovies.add(movie);
            }
        }
        return newMovies;
    }

    @Override
    public List<Movie> findMovieByProducer(String producerFullName) {
        List<Movie> newMovies = new ArrayList<>();
        for (Movie movie : Database.movies) {
            if (movie.getProducer().getFullName().toLowerCase().contains(producerFullName)) {
                newMovies.add(movie);
            }
        }
        return newMovies;
    }

    @Override
    public List<Movie> findMovieByGenre(String genreName) {
        List<Movie> newMovies = new ArrayList<>();
        for (Movie movie : Database.movies) {
            if (movie.getGenre().toString().equals(genreName)) {
                newMovies.add(movie);
            }
        }
        return newMovies;
    }

    @Override
    public String findRoleByActorOrByMovieTitle(String actorName, String movieTitle) {
        for (Movie movie : Database.movies) {
            if (movie.getTitle().toLowerCase().contains(movieTitle)) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getActorFullName().toLowerCase().contains(actorName)) {
                        return actor.getRole();
                    }
                }
            }
        }
        return "Not found.";
    }
}
