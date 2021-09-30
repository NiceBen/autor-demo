package com.ofben.autordemo.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link Required}
 * {@link MovieFinder}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
public class SimpleMovieLister {

    private MovieFinder movieFinder;

    @Autowired
    private MovieFinder[] movieFinders;

    @Autowired
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MovieFinder.class);
        context.register(MovieFinderImpl1.class);
        context.register(MovieFinderImpl2.class);
        context.register(SimpleMovieLister.class);
        context.refresh();
        SimpleMovieLister bean = context.getBean(SimpleMovieLister.class);
        System.out.println(bean.movieFinder);
        MovieFinder[] movieFinders = bean.movieFinders;
        System.out.println("-------------");
        for (MovieFinder m : movieFinders) {
            System.out.println(m);
        }
        context.close();
    }
}
