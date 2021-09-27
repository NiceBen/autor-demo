package com.ofben.autordemo.spring.path.named;

import com.ofben.autordemo.spring.annotation.Genre;
import com.ofben.autordemo.spring.annotation.Offline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * {@link MovieCatalog}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.ofben.autordemo.spring.path.named")
public class MovieCatalogTest {

    @Autowired
    @Qualifier("Action")
    private MovieCatalog quaMovieCatalog;

    @Autowired
    @Genre("Action")
    private MovieCatalog genreMovieCatalog;

    @Autowired
    @Offline
    private MovieCatalog offlineMovieCatalog;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MovieCatalogTest.class);
        context.refresh();

        MovieCatalogTest bean = context.getBean(MovieCatalogTest.class);
        System.out.println(bean.quaMovieCatalog);
        System.out.println(bean.genreMovieCatalog);
        System.out.println(bean.offlineMovieCatalog);

        context.close();
    }

}
