package com.ofben.autordemo.spring.ioc.bean;

import java.util.Map;

/**
 * Bean
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class Command {

    private Map state;

    public void setState(Map state) {
        this.state = state;
    }

    public Object execute() {
        System.out.println("hello world");
        return "hello";
    }
}
