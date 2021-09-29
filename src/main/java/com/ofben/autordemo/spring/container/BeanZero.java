package com.ofben.autordemo.spring.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link Bean}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
public class BeanZero {

    @Bean(initMethod = "init")
    public BeanOne beanOne() {
        System.out.println(beanTwo());
        System.out.println(beanTwo());
        System.out.println(beanTwo());
        return new BeanOne();
    }

    @Bean(destroyMethod = "clear")
    public BeanTwo beanTwo() {
        return new BeanTwo();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanZero.class);
        context.close();
    }
}
