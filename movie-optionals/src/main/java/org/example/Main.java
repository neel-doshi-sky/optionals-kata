package org.example;

public class Main {
    public static void main(String[] args) {

        Movie movie = findMovieByTitle("spiderman");

        System.out.println(movie.getTitle());
    }

    /**
     * Method to find and return a movie by a title search string
     *
     * @param title the title search string
     * @return Movie object
     */
    private static Movie findMovieByTitle(String title) {
        Movie movie = new Movie("spiderman", 130);
        return movie;
    }

}