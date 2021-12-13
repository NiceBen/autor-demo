package com.ofben.autordemo.spring.aop.demo4;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Component
public class Pointcuts {

    @Auditable(AuditCode.OK)
    public void anyPublicMethod() {
        System.out.println("hello world");
    }
}
