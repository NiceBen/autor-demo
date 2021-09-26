package com.ofben.autordemo.spring.definition;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * {@link BeanDefinition}
 *
 * @date 2021-09-26
 * @see BeanDefinition
 * @since 1.0.0
 */
public class TestBean {

    private String name;

    private int age;

    private String hello;

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
