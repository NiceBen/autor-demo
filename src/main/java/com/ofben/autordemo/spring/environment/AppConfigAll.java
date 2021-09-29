package com.ofben.autordemo.spring.environment;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * {@link Profile}
 * {@link ClassPathXmlApplicationContext}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public class AppConfigAll {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("development");
        context.getEnvironment().setActiveProfiles("development", "dev-2");

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(context);
        String xmlResourcePath = "classpath:META-INF/environment/app-config-all-or.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        context.refresh();

        DataSource bean = context.getBean(DataSource.class);
        System.out.println(bean);

        context.close();
    }
}
