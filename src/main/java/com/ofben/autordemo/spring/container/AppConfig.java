package com.ofben.autordemo.spring.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * {@link Bean}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.ofben.autordemo.spring.container")
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean(name = "hello")
    public MyService myService2(MyService myService) {
        return myService;
    }

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        context.close();
    }
}
