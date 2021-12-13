package com.ofben.autordemo.spring.aop.demo4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Component
@Aspect
public class AuditAspectJ {

//    @Pointcut("execution(* com.ofben.autordemo.spring.aop.demo4.Pointcuts.*(..)) && @annotation(auditable))")
    @Pointcut("execution(public * com.ofben.autordemo.spring.aop.demo4.Pointcuts.*(..)) && @annotation(com.ofben.autordemo.spring.aop.demo4.Auditable)")
    public void auditPoint() {

    }

    @Before("auditPoint()")
    public void audit() {
//        AuditCode code = auditable.value();
        System.out.println("audit=");
    }
}

