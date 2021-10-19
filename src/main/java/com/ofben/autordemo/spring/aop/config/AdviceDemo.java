package com.ofben.autordemo.spring.aop.config;

import org.aopalliance.aop.Advice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

/**
 * {@link Advice}
 *
 * @date 2021-10-19
 * @since 1.0.0
 */
@Component
@Aspect
public class AdviceDemo {

    @Pointcut("execution(* com.ofben.autordemo.spring.aop.config.TargetService.*(..))")
    public void targetServiceCut() {
    }


    @Before("com.ofben.autordemo.spring.aop.config.AdviceDemo.targetServiceCut()")
    public void doAccessCheck1() {
        // ...
        System.out.println("before doAccessCheck1()");
    }

    @Before("execution(* com.ofben.autordemo.spring.aop.config.TargetService.*(..))")
    public void doAccessCheck2() {
        // ...
        System.out.println("before doAccessCheck2()");
    }

    @Before("targetServiceCut()")
    public void doAccessCheck3() {
        // ...
        System.out.println("before doAccessCheck3()");
    }

    @AfterReturning(value = "com.ofben.autordemo.spring.aop.config.AdviceDemo.targetServiceCut()", returning = "result")
    public void doAccessCheck4(Object result) {
        // ...
        System.out.println("AfterReturning doAccessCheck4()");
        System.out.println("result:" + result);
    }

    @AfterThrowing(value = "targetServiceCut()", throwing = "ex")
    public void doAccessCheck5(Exception ex) {
        // ...
        System.out.println("AfterThrowing doAccessCheck5()");
        System.out.println("ex:" + ex);
    }

    @After(value = "targetServiceCut()")
    public void doAccessCheck6() {
        // ...
        System.out.println("After doAccessCheck6()");
    }

    @Around("targetServiceCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();

        Object[] args = pjp.getArgs();
        System.out.println("args.length：" + args.length);
        return result;
    }
}
