package com.example.MovieSummary.Service;

import com.example.MovieSummary.Entity.MovieSummary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {

    List<MovieSummary> list;

    public MovieService(){
        list=new ArrayList<>();
        list.add(new MovieSummary(1,"abc","xyz"));
        list.add(new MovieSummary(2,"Avatar","Good Movie"));
    }

    public List<MovieSummary> getMovieList()
    {
        return list;
    }
}
