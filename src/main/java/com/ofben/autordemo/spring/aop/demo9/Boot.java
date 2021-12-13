package com.ofben.autordemo.spring.aop.demo9;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author SL Zhou
 * @date 2021-12-13
 * @since TODO
 */
public class Boot {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/aop/demo9-config.xml");
        PersonService person = factory.getBean(PersonService.class);
        person.getPerson("lisi", 13);
    }
}
