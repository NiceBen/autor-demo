package com.ofben.autordemo.spring.validation.databinding;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link ExoticTypeEditor}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class ExoticTypeMainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/validation/dependon-type.xml");
        DependsOnExoticType type = context.getBean("sample", DependsOnExoticType.class);
        System.out.println(type.getType().getName());

    }
}
