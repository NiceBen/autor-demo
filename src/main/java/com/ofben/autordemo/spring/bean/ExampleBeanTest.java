package com.ofben.autordemo.spring.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ExampleBean}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class ExampleBeanTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/exampleBean.xml");
        context.refresh();

        ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);
        System.out.println(exampleBean);

        context.close();
    }
}
