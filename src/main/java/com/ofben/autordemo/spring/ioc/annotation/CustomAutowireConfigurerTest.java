package com.ofben.autordemo.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

/**
 * {@link CustomAutowireConfigurer}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
public class CustomAutowireConfigurerTest {

    @Autowired
    private MovieCatalog movieCatalog;

    @Autowired
    private Set<MyBean> myBeans;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/annotation/annotation-config.xml");
        context.refresh();

        CustomAutowireConfigurerTest test = context.getBean("test", CustomAutowireConfigurerTest.class);
        System.out.println(test.movieCatalog);
        System.out.println(test.myBeans);

        context.close();

    }






}
