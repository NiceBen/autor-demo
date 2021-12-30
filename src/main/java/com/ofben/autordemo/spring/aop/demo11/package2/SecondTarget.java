package com.ofben.autordemo.spring.aop.demo11.package2;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-21
 * @since TODO
 */
@Component
public class SecondTarget {

    public String second() {
        System.out.println("SecondTarget-second()");
        return "second";
    }
}
