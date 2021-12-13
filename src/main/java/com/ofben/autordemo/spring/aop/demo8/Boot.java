package com.ofben.autordemo.spring.aop.demo8;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
public class Boot {

    public static void main(String[] args) {
        BeanFactory ctx = new ClassPathXmlApplicationContext("META-INF/aop/profiler.xml");
        PersonService person = (PersonService) ctx.getBean("personService");
        person.getPerson("Pengo", 12);
    }
}
