package com.ofben.autordemo.spring.ioc.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * ApplicationContext
 *
 * @date 2021-09-24
 * @since 1.0.0
 */
public class TemplateBeanDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/demoBean.xml");
        context.refresh();

        ComplexObject child = (ComplexObject) context.getBean("child");
        Properties adminEmails = child.getAdminEmails();
        for (String key : adminEmails.stringPropertyNames()) {
            System.out.println(key + "=" + adminEmails.get(key));
        }
        context.close();
    }


}
