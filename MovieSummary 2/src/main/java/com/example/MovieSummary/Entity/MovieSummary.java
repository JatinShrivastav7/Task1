package com.example.MovieSummary.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class MovieSummary {
    private int movieId;
    private String movieTitle;
    private String movieDescription;

    public MovieSummary(){
    }

    public MovieSummary(int movieId, String movieTitle, String movieDescription) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieDescription = movieDescription;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    @Override
    public String toString() {
        return "MovieSummary{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                '}';
    }
}
