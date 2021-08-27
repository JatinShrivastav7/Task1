package com.example.poc.springboothystrix.service;

import com.example.poc.springboothystrix.entity.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MovieService extends SuperMovieService {

    int count1=0;
    int count2=0;
    @Autowired
    public RestTemplate restTemplate;

    // Test case1 : When Hystrix annoted method is called by some other method in service class

    //    public List<Movie> demo()
//    {
//        return getMovieList();
//    }

    //Test case2: When service calls the Hystrix annoted method directly
//    @HystrixCommand(commandKey = "MovieTag", fallbackMethod = "movieFallBack",
//    commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
//    })
//    public List<Movie> getMovieList()
//    {
//
//        List<Movie> movieSummary=restTemplate.getForObject("http://localhost:8081/summary",List.class);
//        count1++;
//        log.info("Invoked getMovieList " + count1 +" "+"time");
//        return movieSummary;
//    }
//
//    public List<Movie> movieFallBack()
//    {
//        count2++;
//                log.info("Fallback Invoke " +count2+ " "+"time");
//        List<Movie> fallBackList=new ArrayList<>();
//        fallBackList.add(new Movie(00,
//                "no movie found",
//                "Service not avilable"));
//        return fallBackList;
//    }

    // Test Case 4:
    @Override
    @HystrixCommand(commandKey = "ChildClassTag", fallbackMethod = "movieFallBack",
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
        log.info("Invoked Child Class getMovieList " + count1 +" "+"time");
        return movieSummary;
    }

    public List<Movie> movieFallBack()
    {
        count2++;
        log.info("Child Class Fallback Invoke " +count2+ " "+"time");
        List<Movie> fallBackList=new ArrayList<>();
        fallBackList.add(new Movie(00,
                "no movie found",
                "Service not avilable"));
        return fallBackList;
    }
}
