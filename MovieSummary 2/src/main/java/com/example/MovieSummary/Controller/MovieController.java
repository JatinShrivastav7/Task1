package com.example.MovieSummary.Controller;

import com.example.MovieSummary.Entity.MovieSummary;
import com.example.MovieSummary.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/summary")
    public List<MovieSummary> getMovies()
    {
        return movieService.getMovieList();
    }

}
