package com.ofben.autordemo.spring.jsr330;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

/**
 * {@link Inject}
 * {@link Named}
 *
 * @date 2021-09-28
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.ofben.autordemo.spring.jsr330")
public class SimpleMovieLister2 {

    private Provider<Finder> finder;

    @Inject
    public void setMovieFinder(@Named("movieFinder") Provider<Finder> finder) {
        this.finder = finder;
    }

    public void listMovies() {
        this.finder.get().findMovies();
        // ...
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SimpleMovieLister2.class);
        context.refresh();

        SimpleMovieLister2 bean = context.getBean(SimpleMovieLister2.class);
        bean.listMovies();

        context.close();
    }
}
