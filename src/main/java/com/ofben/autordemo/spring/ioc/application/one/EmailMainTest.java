package com.ofben.autordemo.spring.ioc.application.one;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link ApplicationListener}
 * {@link ApplicationEvent}
 *
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class EmailMainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmailService.class,BlockedListNotifier.class);

        EmailService bean = context.getBean(EmailService.class);
        bean.sendEmail("hello", "world");
        context.close();
    }
}
