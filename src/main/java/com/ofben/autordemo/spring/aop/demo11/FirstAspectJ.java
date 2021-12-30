package com.ofben.autordemo.spring.aop.demo11;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author SL Zhou
 * @date 2021-12-21
 * @since TODO
 */
@Aspect
@Component
public class FirstAspectJ {

    @Pointcut("execution( public * com.ofben.autordemo.spring.aop.demo11.package1.FirstTarget.first(..))")
    public void pointcut1() {
    }

    @Pointcut("execution( public * com.ofben.autordemo.spring.aop.demo11.package1.FirstTarget.first2(..))")
    public void pointcut2() {
    }


    @Before("pointcut1()")
    public void before1(JoinPoint joinPoint) throws Exception {
        System.out.println("这是FirstAspectJ-pointcut1()-before1()实现");
    }

    @Around("pointcut1()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是FirstAspectJ-pointcut1()-around()实现-前");
        pjp.proceed();
        System.out.println("这是FirstAspectJ-pointcut1()-around()实现-后");
    }


    // ---

    @Before("pointcut2()")
    public void before2(JoinPoint joinPoint) throws Exception {
        System.out.println("这是FirstAspectJ-pointcut2()-before2()实现");
    }
}
