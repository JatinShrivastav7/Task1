package com.example.poc.springboothystrix.controller;

import com.example.poc.springboothystrix.entity.Movie;
import com.example.poc.springboothystrix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Bean

    public RestTemplate template(){
        return new RestTemplate();
    }

    @GetMapping("/movie")
    public List<Movie> getMovies()
    {
        return movieService.getMovieList();
    }
}
