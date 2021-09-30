package com.ofben.autordemo.spring.ioc.definition;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link TestBean}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class TestBeanMainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/definition/testBean.xml");

        context.refresh();

        DerivedTestBean bean = context.getBean("derivedTestBean", DerivedTestBean.class);
        System.out.println(bean);

        context.close();
    }
}
