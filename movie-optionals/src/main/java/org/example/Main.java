package org.example;

import java.util.Optional;

public class Main {
    public static MovieService movieService = new MovieService();

    public static void main(String[] args) {

        Optional<Movie> movieOptional = findMovieByTitle("spiderman");

//        if (movie != null){
//            System.out.println(movie.getTitle());
//        } else {
//            System.out.println("movie not found");
//        }

//        if (movieOptional.isPresent()) {
//            System.out.println(movieOptional.get().getTitle());
//        } else {
//            System.out.println("movie not found");
//        }

//        Movie movie = movieOptional.orElse(new Movie("not found"));
//        System.out.println(movie.getTitle());
//        System.out.println(movieOptional.orElseGet(() -> new Movie("not found")).getTitle());

//        movieOptional.ifPresent(movie -> System.out.println(movie.getTitle()));

//        movieOptional.ifPresentOrElse(movie -> System.out.println(movie.getDuration()), () -> System.out.println("no movie found"));

//        System.out.println(movieOptional.map(Movie::getTitle));

        System.out.println(movieOptional.flatMap(Movie::getTitle).orElse("not found"));



    }

    public static Optional<Movie> findMovieByTitle(String title) {
        Movie movie = movieService.findMovieByTitle(title);
        return Optional.ofNullable(movie);
    }


}

class MovieService {

    public Movie findMovieByTitle(String title) {
        Movie movie = new Movie("spiderman", null);
        return movie;
    }


}