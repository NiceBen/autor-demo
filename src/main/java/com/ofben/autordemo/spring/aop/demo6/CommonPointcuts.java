package com.ofben.autordemo.spring.aop.demo6;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Component
public class CommonPointcuts {

    @Idempotent
    public void businessService() {
        System.out.println("businessService()");
    }
}
