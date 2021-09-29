package com.ofben.autordemo.spring.jsr330;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

/**
 * {@link Inject}
 * {@link Named}
 *
 * @date 2021-09-28
 * @since 1.0.0
 */
@Named("simpleMovieLister4")
@ComponentScan("com.ofben.autordemo.spring.jsr330")
public class SimpleMovieLister4 {

    private Optional<Finder> finder;

    @Inject
    public void setMovieFinder(@Named("movieFinder") Optional<Finder> finder) {
        this.finder = finder;
    }

    public void listMovies() {
        if (finder.isPresent()) {
            this.finder.get().findMovies();
        }
        // ...
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SimpleMovieLister4.class);
        context.refresh();

        SimpleMovieLister4 bean = context.getBean(SimpleMovieLister4.class);
        bean.listMovies();

        context.close();
    }
}
