package com.ofben.autordemo.spring.path;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * {@link AnnotationConfigApplicationContext}
 * {@link ComponentScan}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Configuration
//@ComponentScan(basePackages = "com.ofben.autordemo.spring.path")
@ComponentScan(value = "com.ofben.autordemo.spring.path",
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern=".*Stub.*Repository"),
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value= Controller.class))
public class AppConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        SimpleMovieLister bean = context.getBean(SimpleMovieLister.class);
        System.out.println(bean.getMovieFinder());

        context.close();
    }


}
