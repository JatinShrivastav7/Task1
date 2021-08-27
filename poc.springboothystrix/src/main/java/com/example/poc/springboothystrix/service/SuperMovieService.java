package com.example.poc.springboothystrix.service;

import com.example.poc.springboothystrix.entity.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SuperMovieService {

    int count1=0;
    int count2=0;
    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(commandKey = "SuperClassTag", fallbackMethod = "movieFallBack",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            })
    public List<Movie> getMovieList()
    {

        List<Movie> movieSummary=restTemplate.getForObject("http://localhost:8081/summary",List.class);
        count1++;
        log.info("Invoked Super Class getMovieList " + count1 +" "+"time");
        return movieSummary;
    }
    public List<Movie> movieFallBack()
    {
        count2++;
        log.info("Super Class Fallback Invoke " +count2+ " "+"time");
        List<Movie> fallBackList=new ArrayList<>();
        fallBackList.add(new Movie(00,
                "no movie found",
                "Service not avilable"));
        return fallBackList;
    }

}
