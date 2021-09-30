package com.ofben.autordemo.spring.ioc.environment;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/**
 * {@link MessageSource}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class MessageSourceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("production");
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("classpath:/META-INF/environment/beans.xml");
        context.refresh();
        String message = context.getMessage("message", null, "Default", Locale.ENGLISH);
        System.out.println(message);
    }
}
