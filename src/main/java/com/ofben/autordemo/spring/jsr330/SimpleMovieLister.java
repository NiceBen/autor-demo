package com.ofben.autordemo.spring.jsr330;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * {@link Inject}
 * {@link Named}
 *
 * @date 2021-09-28
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.ofben.autordemo.spring.jsr330")
public class SimpleMovieLister {

    private Finder Finder;

    @Inject
    public void setMovieFinder(@Named("movieFinder") Finder Finder) {
        this.Finder = Finder;
    }

    public void listMovies() {
        this.Finder.findMovies();
        // ...
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SimpleMovieLister.class);
        context.refresh();

        SimpleMovieLister bean = context.getBean(SimpleMovieLister.class);
        bean.listMovies();

        context.close();
    }
}
