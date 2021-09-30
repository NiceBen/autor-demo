package com.ofben.autordemo.spring.ioc.container.imports;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link ConfigA}
 * {@link ConfigA}
 * {@link A}
 * {@link B}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public class Config {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);
        ConfigB configB = context.getBean(ConfigB.class);
        System.out.println("configB:" + configB);
        B b = context.getBean(B.class);
        System.out.println("B:" + b);

        System.out.println("-----------");
        ConfigA configA = context.getBean(ConfigA.class);
        System.out.println("configA:" + configA);
//        A a = context.getBean(A.class);
//        System.out.println("A:" + a);
    }
}
