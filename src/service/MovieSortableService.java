package service;

public interface MovieSortableService {
    void sortMoviesByTitle(String ascOrDesc);
    void sortMoviesByYear(String ascOrDesc);
    void sortByProducer(String nameOrLastName);
}
