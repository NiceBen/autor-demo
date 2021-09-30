package com.ofben.autordemo.spring.ioc.environment;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Properties;

/**
 * {@link MutablePropertySources}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class EnvironmentSet {

    public static void main(String[] args) {
        final String key = "my-property";
        ConfigurableApplicationContext ctx = new GenericApplicationContext();
        MutablePropertySources sources = ctx.getEnvironment().getPropertySources();

        Properties p = new Properties();
        p.setProperty(key, "hello world");

//        PropertiesPropertySource source = new PropertiesPropertySource("My-pp", p);
        MyPropertySource source = new MyPropertySource("My-pp", p);

//        Map<String, Object> map = new HashMap<>();
//        map.put(key, "hello world");
//        MyPropertySource myPropertySource = new MyPropertySource(key, map);
        sources.addFirst(source);

        ctx.refresh();
        Environment env = ctx.getEnvironment();
        if (env.containsProperty(key)) {
            String value = env.getProperty(key);
            System.out.println(value);
        }
        ctx.close();
    }
}
