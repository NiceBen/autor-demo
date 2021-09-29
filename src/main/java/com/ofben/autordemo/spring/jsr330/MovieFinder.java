package com.ofben.autordemo.spring.jsr330;

import org.springframework.stereotype.Component;

/**
 * {@link Component}
 *
 * @date 2021-09-28
 * @since 1.0.0
 */
@Component
public class MovieFinder implements Finder {

    @Override
    public void findMovies() {
        System.out.println(this);
    }
}
