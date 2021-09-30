package com.ofben.autordemo.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Map;

/**
 * Beans
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Configuration
@PropertySource("classpath:/META-INF/annotation/app-config.properties")
@EnableConfigurationProperties(AppConfigProperties.class)
public class AppConfig {

//    private final String catalog;

    @Autowired
    private AppConfigProperties appProperties;

    private final Map<String, Integer> countOfMoviesPerCatalog;

    public AppConfig(@Value("#{{'Thriller': 100, 'Comedy':300}}") Map<String, Integer> countOfMoviesPerCatalog) {
        this.countOfMoviesPerCatalog = countOfMoviesPerCatalog;
    }

//    public AppConfig(@Value("#{systemProperties['user.catalog'] + 'Catalog'}") String catalog) {
//        this.catalog = catalog;
//    }

//    public AppConfig(@Value("${catalog.name:defaultCatalog}") String catalog) {
//        this.catalog = catalog;
//    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

//    @Bean
//    public ConversionService conversionService() {
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//        conversionService.addConverter(new MyConverter());
//        return conversionService;
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        AppConfig appConfig = context.getBean("appConfig", AppConfig.class);
        System.out.println(appConfig.countOfMoviesPerCatalog);
        System.out.println("---------");
        Map<String, Integer> map = appConfig.countOfMoviesPerCatalog;
        map.forEach((key,value) -> System.out.println(key + "=" + value));

        context.close();
    }
}
