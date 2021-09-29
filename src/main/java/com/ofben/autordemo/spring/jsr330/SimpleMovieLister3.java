package com.ofben.autordemo.spring.jsr330;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.lang.Nullable;

import javax.annotation.ManagedBean;
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
@ManagedBean
@ComponentScan("com.ofben.autordemo.spring.jsr330")
public class SimpleMovieLister3 {

    private Provider<Finder> finder;

    @Inject
    public void setMovieFinder(@Nullable @Named("movieFinder") Provider<Finder> finder) {
        this.finder = finder;
    }

    public void listMovies() {
        this.finder.get().findMovies();
        // ...
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SimpleMovieLister3.class);
        context.refresh();

        SimpleMovieLister3 bean = context.getBean(SimpleMovieLister3.class);
        bean.listMovies();

        context.close();
    }
}
