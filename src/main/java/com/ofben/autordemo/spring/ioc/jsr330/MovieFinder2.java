package com.ofben.autordemo.spring.ioc.jsr330;

import org.springframework.stereotype.Component;

/**
 * {@link Component}
 *
 * @date 2021-09-28
 * @since 1.0.0
 */
@Component
public class MovieFinder2 implements Finder {

    @Override
    public void findMovies() {
        System.out.println(this);
    }
}
