package service;

import module.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieFindableService {
    List<Movie> getAllMovies();
    List<Movie>findMovieByFullTitleOrPartTitle(String title);
    List<Movie>findMovieByActorName(String actorName);
    List<Movie>findMovieByYear(int year);
    List<Movie>findMovieByProducer(String producerFullName);
    List<Movie>findMovieByGenre(String genreName);
    String findRoleByActorOrByMovieTitle(String actorName, String movieTitle);
}
