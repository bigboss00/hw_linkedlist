package database;

import enums.Genre;
import module.Actor;
import module.Movie;
import module.Producer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Movie> movies = new ArrayList<>(
            List.of(
                    new Movie("Titanic", LocalDate.of(1997, 11, 1), Genre.DRAMA, new Producer("James", "Cameron"), new ArrayList<>(List.of(new Actor("Leonardo DiCaprio", "Jack"), new Actor("Kate Winslet", "Rose")))),
                    new Movie("Forest Gump", LocalDate.of(1994, 6, 23), Genre.DRAMA, new Producer("Robert", "Zemeckis"), new ArrayList<>(List.of(new Actor("Tom Hanks", "Forrest Gump"), new Actor("Robin Wright", "Jenny Curran")))),
                    new Movie("Bruce Almighty", LocalDate.of(2003, 5, 14), Genre.COMEDY, new Producer("Tom", "Shadyac"), new ArrayList<>(List.of(new Actor("Jim Carrey", "Bruce"), new Actor("Morgan Freeman", "God")))),
                    new Movie("The Matrix", LocalDate.of(1999, 3, 31), Genre.FANTASY, new Producer("Lana", "Wachowski"), new ArrayList<>(List.of(new Actor("Keanu Reeves", "Neo"), new Actor("Laurence Fishburne", "Morpheus")))),
                    new Movie("Gladiator", LocalDate.of(2000, 5, 5), Genre.HISTORY, new Producer("Douglas", "Wick"), new ArrayList<>(List.of(new Actor("Russell Crowe", "Maximus"), new Actor("Joaquin Phoenix", "Commodus")))),
                    new Movie("Interstellar", LocalDate.of(2014, 10, 26), Genre.ADVENTURE, new Producer("Emma", "Thomas"), new ArrayList<>(List.of(new Actor("Matthew McConaughey", "Cooper"), new Actor("Jessica Chastain", "Murphy")))),
                    new Movie("Avatar", LocalDate.of(2009, 12, 17), Genre.SCIENCE_FICTION, new Producer("James", "Cameron"), new ArrayList<>(List.of(new Actor("Sam Worthington", "Jake Sully"), new Actor("Zoe Saldana", "Neytiri")))),
                    new Movie("Tarzan", LocalDate.of(1999, 6, 18), Genre.ADVENTURE, new Producer("Bonnie", "Arnold"), new ArrayList<>(List.of(new Actor("Tony Goldwyn", "Tarzan"), new Actor("Minnie Driver", "Jane Porter"))))
            )
    );


}
