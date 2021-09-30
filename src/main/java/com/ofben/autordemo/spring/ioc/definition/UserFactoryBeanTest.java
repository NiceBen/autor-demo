package com.ofben.autordemo.spring.ioc.definition;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link UserFactoryBean}
 * {@link User}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class UserFactoryBeanTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/definition/userFactoryBean.xml");
        context.refresh();

        User user = context.getBean("userFactoryBean", User.class);
        System.out.println(user);

        context.close();
    }
}
