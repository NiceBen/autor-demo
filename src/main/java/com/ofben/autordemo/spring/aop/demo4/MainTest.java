package com.ofben.autordemo.spring.aop.demo4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainTest.class, AuditAspectJ.class, Pointcuts.class);
        context.refresh();

        Pointcuts pointcuts = context.getBean(Pointcuts.class);
        pointcuts.anyPublicMethod();
    }
}
