package com.ofben.autordemo.spring.aop.demo6;

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
        context.register(CommonPointcuts.class, ConcurrentOperationExecutor.class);
        context.refresh();

        CommonPointcuts bean = context.getBean(CommonPointcuts.class);
        bean.businessService();
    }
}
