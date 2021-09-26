package com.ofben.autordemo.spring.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * {@link MyScope}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class MyScopeTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerScope("myScope", new MyScope());

    }

}
