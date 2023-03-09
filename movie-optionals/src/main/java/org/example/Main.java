package org.example;

public class Main {
    public static MovieService movieService = new MovieService();

    public static void main(String[] args) {

        Movie movie = findMovieByTitle("spiderman");

        System.out.println(movie.getTitle());
    }

    public static Movie findMovieByTitle(String title) {
        Movie movie = movieService.findMovieByTitle(title);
        return movie;
    }

}

class MovieService {

    public Movie findMovieByTitle(String title) {
        Movie movie = new Movie("spiderman", 130);
        return movie;
    }


}