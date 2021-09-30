package com.ofben.autordemo.spring.ioc.definition;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * {@link BeanDefinition}
 * {@link TestBean}
 *
 * @date 2021-09-26
 * @see BeanDefinition
 * @see TestBean
 * @since 1.0.0
 */
public class DerivedTestBean extends TestBean {

    private String name;

    private String address;

    public void init() {
        System.out.println("init()");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DerivedTestBean{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
