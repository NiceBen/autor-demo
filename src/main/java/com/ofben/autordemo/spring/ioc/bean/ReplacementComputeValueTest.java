package com.ofben.autordemo.spring.ioc.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ReplacementComputeValue}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class ReplacementComputeValueTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/myValueCalculator.xml");

        context.refresh();
        MyValueCalculator myValueCalculator = context.getBean("myValueCalculator", MyValueCalculator.class);
        System.out.println(myValueCalculator.computeValue("hello"));

        context.close();
    }
}
