package com.ofben.autordemo.spring.path;

import org.springframework.stereotype.Service;

/**
 * Bean
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Service
public class SimpleMovieLister {

    private final MovieFinder movieFinder;

    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public MovieFinder getMovieFinder() {
        return movieFinder;
    }
}
