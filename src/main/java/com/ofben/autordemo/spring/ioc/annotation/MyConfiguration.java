package com.ofben.autordemo.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * {@link Qualifier}
 * {@link StringStore}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Configuration
public class MyConfiguration {

    @Autowired
    private Store<String> s1;

    @Autowired
    private Store<Integer> s2;

    @Autowired
    private List<Store<String>> s;

    @Bean
    public StringStore stringStore() {
        return new StringStore();
    }

    @Bean
    public IntegerStore integerStore() {
        return new IntegerStore();
    }

    @Bean
    public Store<String> stringStore2() {
        return new Store<>();
    }

    @Bean
    public Store<Integer> integerStore2() {
        return new Store<>();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfiguration.class);
        context.refresh();

        MyConfiguration bean = context.getBean(MyConfiguration.class);
        System.out.println(bean.s1);
        System.out.println(bean.s2);
        System.out.println(bean.s);

        context.close();
    }
}
