package com.ofben.autordemo.spring.aopapi.demo3;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @date 2021-12-14
 * @since TODO
 */
public class Boot {
    public static void main(String[] args) {
        BeanFactory context = new ClassPathXmlApplicationContext("META-INF/aopapi/proxy-factory-bean2.xml");
        Object bean = context.getBean("person");
        if (bean instanceof Person) {
            Person person = (Person) bean;
            System.out.println("Person=" + person);
        }
    }
}
