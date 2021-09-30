package com.ofben.autordemo.spring.ioc.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link PostConstruct}
 * {@link PreDestroy}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
public class CachingMovieLister {

    private Map<String, String> cache;

    @PostConstruct
    private void init() {
        if (cache == null) {
            cache = new HashMap<>();
        }
        cache.put("key", "init");
    }

    @PreDestroy
    private void destroy() {
        cache.clear();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CachingMovieLister.class);
        context.refresh();

        CachingMovieLister bean = context.getBean(CachingMovieLister.class);
        Map<String, String> map = bean.cache;
        map.forEach((key, value) -> System.out.println(key + "=" + value));

        context.close();
    }

}
