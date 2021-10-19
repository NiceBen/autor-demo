package com.ofben.autordemo.spring.aop.config.mock;

import com.ofben.autordemo.spring.aop.config.TargetService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Application context
 *
 * @date 2021-10-19
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.ofben.autordemo.spring.aop.config")
public class ApplicationContextDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextDemo.class);
        TargetService bean = context.getBean(TargetService.class);
        bean.invoked();
        context.close();
    }
}
