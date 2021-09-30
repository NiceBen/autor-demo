package com.ofben.autordemo.spring.ioc.path;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ClassPathXmlApplicationContext}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Configuration
public class AppConfig2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/path/app-config.xml");

        SimpleMovieLister bean = context.getBean(SimpleMovieLister.class);
        System.out.println(bean.getMovieFinder());

        context.close();
    }
}
