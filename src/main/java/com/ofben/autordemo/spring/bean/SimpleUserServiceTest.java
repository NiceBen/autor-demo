package com.ofben.autordemo.spring.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * {@link SimpleUserService}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class SimpleUserServiceTest {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/simpleUserService.xml");

        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("classpath:/META-INF/simpleUserService.xml");
        context.refresh();

        SimpleUserService simpleUserService = context.getBean("simpleUserService", SimpleUserService.class);
        UserPreferences userPreferences = simpleUserService.getUserPreferences();
        System.out.println(userPreferences);

        context.close();
    }
}
