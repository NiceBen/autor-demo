package com.ofben.autordemo.spring.ioc.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Set;

/**
 * {@link SomeClass} Test
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class SomeClassTest {

    public static void main(String[] args) throws NoSuchFieldException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/someClass.xml");
        context.refresh();

        SomeClass someClass = (SomeClass) context.getBean("someClass");
        Map<String, Float> accounts = someClass.getAccounts();
        Set<String> keySet = accounts.keySet();
        for (String key : keySet) {
            System.out.println(key + "=" + accounts.get(key));
        }
        context.close();
    }
}
