package com.ofben.autordemo.spring.ioc.environment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;

/**
 * {@link GenericApplicationContext}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class EnvironmentGet {

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericApplicationContext();
        Environment env = ctx.getEnvironment();
        boolean containsProperty = env.containsProperty("my-property");
        System.out.println("Does my environment contain the 'my-property' property? " + containsProperty);
    }
}
