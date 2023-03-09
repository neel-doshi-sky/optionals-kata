package org.example;

public class Movie {

    private final String title;
    private Integer duration;

    public Movie(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
            "title='" + title + '\'' +
            ", duration=" + duration +
            '}';
    }
}
