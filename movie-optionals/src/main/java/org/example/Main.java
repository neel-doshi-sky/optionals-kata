package org.example;

import java.util.Optional;

public class Main {
    public static MovieService movieService = new MovieService();

    public static void main(String[] args) {


        // the old-fashioned approach below, using null everywhere is a code smell! Optionals were brought in to produce more readable code and reduce null checks
        //Movie move = new Movie("test");
//        if (movie != null){
//            System.out.println(movie.getTitle());
//        } else {
//            System.out.println("movie not found");
//        }

        // store the method call in an optional to let the user (us as the user of the code) know that you may not get a movie back
        Optional<Movie> movieOptional = findMovieByTitle("spiderman");

        // initial optional usage that mirrors the above
        // isPresent() returns a boolean value and checks to see if the Optional contains the value or not
        // get() grabs the value from inside the optional (DO NOT USE, use the alternative orElseThrows as it will throw an exception if null )
        if (movieOptional.isPresent()) {
            System.out.println(movieOptional.get().getTitle());
        } else {
            System.out.println("movie not found");
        }

        // orElse() if the optional does not contain a Movie object, provide a default Movie to use
        System.out.println(movieOptional.orElse(new Movie("not found")).getTitle());

        //orElseGet() if the optional does not contain a Movie object, call a Supplier to get a Movie object
        System.out.println(movieOptional.orElseGet(() -> new Movie("not found")).getTitle());

        // ifPresent() takes an Consumer action, if the optional contains a value, perform a action or a "side effect", this action only executes if the optional has a movie
        movieOptional.ifPresent(movie -> System.out.println(movie.getTitle()));

        // ifPresentOrElse() takes a Consumer action and Runnable empty action, if the optional contains a movie, perform the action, otherwise perform the empty action
        movieOptional.ifPresentOrElse(movie -> System.out.println(movie.getDuration()), () -> System.out.println("no movie found"));

        // map() will transform Optional<Movie> to an Optional of whatever you would like! here we only care about the title so we map to the optional of the Movie title
        // which is Optional<String> and chain more Optional methods to this such as orElse()
        System.out.println(movieOptional.map(Movie::getTitle).orElse("not found"));

        //flatMap() in more complex objects, you can end up with an Optional<Optional<String>>, using flatMap we can remove the outer Optional and flatten it to Optional<String> and continue
        System.out.println(movieOptional.flatMap(Movie::getTitle).orElse("not found"));
    }

    /**
     * Method that returns an optional of movie
     * this tells the caller of this method that there is a chance that you may not get a movie back
     *
     * @param title the search string for the title
     * @return if a movie is returned from the database return Optional.ofNullable(movie) else Optional.ofNullable(null)
     */
    public static Optional<Movie> findMovieByTitle(String title) {
        Movie movie = movieService.findMovieByTitle(title);
        return Optional.ofNullable(movie);
    }


}

/**
 * Class to mimic a service that talks to the database
 */
class MovieService {

    //dummy method that mimics a database call
    // to test optionals set movie to null for sad case and return movie for happy case
    public Movie findMovieByTitle(String title) {
        Movie movie = new Movie("spiderman", null);
        return movie;
    }


}