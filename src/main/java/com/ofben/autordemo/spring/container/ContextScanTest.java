package com.ofben.autordemo.spring.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link AnnotationConfigApplicationContext}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public class ContextScanTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.ofben.autordemo.spring.container");
        context.refresh();
        context.close();
    }
}
