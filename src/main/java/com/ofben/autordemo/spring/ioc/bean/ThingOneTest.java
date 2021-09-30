package com.ofben.autordemo.spring.ioc.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ThingOne}
 *
 * @date 2021-09-26
 * @see ThingOne
 * @since 1.0.0
 */
public class ThingOneTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/thingOne.xml");
        context.refresh();

        ThingOne thingOne = context.getBean("thingOne", ThingOne.class);
        System.out.println(thingOne);

        ThingOne thingOne2 = context.getBean("thingOne2", ThingOne.class);
        System.out.println(thingOne2);

        ThingOne thingOne3 = context.getBean("thingOne3", ThingOne.class);
        System.out.println(thingOne3);

        context.close();
    }
}
