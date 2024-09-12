package service.impl;

import database.Database;
import module.Movie;
import service.MovieSortableService;

import java.util.ArrayList;
import java.util.Comparator;

public class MovieSortableServiceImpl implements MovieSortableService {
    @Override
    public void sortMoviesByTitle(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Database.movies.sort(Comparator.comparing(Movie::getTitle));
        }else if (ascOrDesc.equalsIgnoreCase("desc")) {
            Database.movies.sort(Comparator.comparing(Movie::getTitle).reversed());
        }
    }

    @Override
    public void sortMoviesByYear(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Database.movies.sort(Comparator.comparing(Movie::getYear));
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            Database.movies.sort(Comparator.comparing(Movie::getYear).reversed());
        }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equalsIgnoreCase("asc")) {
            Database.movies.sort(Comparator.comparing(movie -> movie.getProducer().getFirstName()));
        } else if (nameOrLastName.equalsIgnoreCase("desc")) {
            Database.movies.sort(Comparator.comparing(movie -> movie.getProducer().getFirstName()));
        }
    }
}
