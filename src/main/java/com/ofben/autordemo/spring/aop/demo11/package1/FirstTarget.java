package com.ofben.autordemo.spring.aop.demo11.package1;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-21
 * @since TODO
 */
@Component
public class FirstTarget {

    public String first() {
        System.out.println("FirstTarget-first()");
        return "first";
    }

    public String first2() {
        System.out.println("FirstTarget-first2()");
        return "first2";
    }
}
