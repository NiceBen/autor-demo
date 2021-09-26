package com.ofben.autordemo.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * Bean
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class ExampleBean implements InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware {

    private int age;

    public void setAge(int age) {
        System.out.println("setAge " + this.age);
        this.age = age;
        System.out.println("setAge2 " + this.age);
    }

    public void init() {
        System.out.println("invoked init");
        age = 11;
        System.out.println("invoked " + age);
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "age=" + age +
                '}';
    }

    @PostConstruct
    public void postC() {
        System.out.println("postC init");
        age = 33;
        System.out.println("postC " + age);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet init");
        age = 22;
        System.out.println("afterPropertiesSet " + age);
    }


    // --------------------

    public void cleanup() {
        // do some destruction work (like releasing pooled connections)
        System.out.println("destroy cleanup");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("disposableBean invoked");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware Invoked");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware Invoked");
    }
}
