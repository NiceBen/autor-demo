package com.ofben.autordemo.spring.definition;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link FirstBeanPostProcessor}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class FirstBeanPostProcessorTest {

    private final String hello = "world";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/definition/beanPostProcessor.xml");
        System.out.println("---------");
//        context.refresh();

        Message message = context.getBean("message", Message.class);

        context.close();
    }
}
