package com.ofben.autordemo.spring.aop.config;

import org.springframework.stereotype.Component;

/**
 * Target
 *
 * @date 2021-10-19
 * @since 1.0.0
 */
@Component
public class TargetServiceImpl implements TargetService {

    @Override
    public Object invoked() {
        System.out.println("invoked");
//        if (true) {
//            throw new RuntimeException("error");
//        }
        return "hello";
    }
}
