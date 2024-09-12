import service.MovieFindableService;
import service.MovieSortableService;
import service.impl.MovieFindableServiceImpl;
import service.impl.MovieSortableServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MovieFindableService movieFindableService = new MovieFindableServiceImpl();
        MovieSortableService movieSortableService = new MovieSortableServiceImpl();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Get All Movies");
            System.out.println("2. Find Movie by Title or Part Title");
            System.out.println("3. Find Movie by Actor");
            System.out.println("4. Find Movie by Year");
            System.out.println("5. Find Movie by Producer");
            System.out.println("6. Find Movie by Genre");
            System.out.println("7. Find Role by Actor and Movie Name");
            System.out.println("8. Sort Movies by Title");
            System.out.println("9. Sort Movies by Year");
            System.out.println("10. Sort Movies by Producer Name or Last Name");
            System.out.println("0. Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println(movieFindableService.getAllMovies());
                        break;
                    case 2:
                        String movieTitle = "";
                        scanner.nextLine();
                        while (movieTitle.isEmpty()) {
                            System.out.println("Enter movie title or part title: ");
                            movieTitle = scanner.nextLine();
                            if (movieTitle.isEmpty()) {
                                System.out.println("Movie title cannot be empty! Please enter a valid movie title.");
                            }
                        }
                        System.out.println(movieFindableService.findMovieByFullTitleOrPartTitle(movieTitle));
                        break;
                    case 3:
                        String movieActor = "";
                        movieActor = scanner.nextLine();
                        while (movieActor.isEmpty()) {
                            System.out.println("Enter movie actor or part actor: ");
                            movieActor = scanner.nextLine();
                            if (movieActor.isEmpty()) {
                                System.out.println("Movie actor cannot be empty! Please enter a valid movie actor.");
                            }
                        }
                        System.out.println(movieFindableService.findMovieByActorName(movieActor));
                        break;
                    case 4:
                        System.out.println("Enter movie year:");
                        int year = -1;
                        while (year <= 0) {
                            try {
                                year = scanner.nextInt();
                                if (year <= 0) {
                                    System.out.println("Year must be a positive number! Please try again:");
                                } else {
                                    System.out.println(movieFindableService.findMovieByYear(year));
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter only year with digits!");
                                scanner.next();
                            }
                        }
                        break;
                    case 5:
                        String producerName = "";
                        producerName = scanner.nextLine().toLowerCase();
                        while (producerName.isEmpty()) {
                            System.out.println("Enter producer full name: ");
                            producerName = scanner.nextLine().toLowerCase();
                            if (producerName.isEmpty()) {
                                System.out.println("Producer full name cannot be empty! Please enter a valid producer full name.");
                            }
                        }
                        System.out.println(movieFindableService.findMovieByProducer(producerName));
                        break;
                    case 6:
                        String genre = "";
                        genre = scanner.nextLine().toUpperCase().trim();
                        System.out.println(genre);
                        while (genre.isEmpty()) {
                            System.out.println("Enter genre: ");
                            genre = scanner.nextLine().toUpperCase().trim();
                            System.out.println(genre);
                            if (genre.isEmpty()) {
                                System.out.println("Genre cannot be empty! Please enter a valid genre.");
                            }
                        }
                        System.out.println(movieFindableService.findMovieByGenre(genre));
                        break;
                    case 7:
                        String movieTitl = "";
                        String actorFullName = "";
                        movieTitl = scanner.nextLine().toLowerCase();
                        while (movieTitl.isEmpty() || actorFullName.isEmpty()) {
                            System.out.println("Enter movie title: ");
                            movieTitl = scanner.nextLine().toLowerCase();
                            System.out.println("Enter actor full name: ");
                            actorFullName = scanner.nextLine().toLowerCase();
                            if (movieTitl.isEmpty() || actorFullName.isEmpty()) {
                                System.out.println("Movie title and actor full name cannot be empty! Please enter valid information.");
                            }
                        }
                        System.out.println(movieFindableService.findRoleByActorOrByMovieTitle(actorFullName, movieTitl));
                        break;
                    case 8:
                        System.out.println("Sort by name: asc or desc?");
                        String ascOrDesc = scanner.next();
                        movieSortableService.sortMoviesByTitle(ascOrDesc);
                        System.out.println(movieSortableService);
                        break;
                    case 9:
                        System.out.println("Sort by year: asc or desc?");
                        String ascOrDesc2 = scanner.next();
                        movieSortableService.sortMoviesByYear(ascOrDesc2);
                        System.out.println(movieSortableService);
                        break;
                    case 10:
                        System.out.println("Sort by producer: asc or desc?");
                        String ascOrDesc3 = scanner.next();
                        movieSortableService.sortByProducer(ascOrDesc3);
                        System.out.println(movieSortableService);
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid choice!");
                }
            }catch (InputMismatchException e) {
                System.err.println("Input only number in range 0-10");
                scanner.nextLine();
            }
        }
    }
}