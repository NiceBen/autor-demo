package com.ofben.autordemo.spring.ioc.environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link PropertySource}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
@Configuration
//@PropertySource("classpath:/META-INF/environment/app-property-source.properties")
//@PropertySource("classpath:/META-INF/${testbean.path:hello}/app-property-source2.properties")
@MyPropertySources
public class AppPropertyTest {

    @Inject
    private Environment env;

    @Bean
    public Map<String, String> myMap() {
        String name = env.getProperty("testbean.name");
        Map<String, String> map = new HashMap<>();
        map.put("test.name", name);
        return map;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppPropertyTest.class);
        Map myMap = context.getBean("myMap", Map.class);
        Object name = myMap.get("test.name");
        System.out.println(name.toString());
    }
}
