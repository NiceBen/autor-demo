package com.ofben.autordemo.spring.aop.demo11;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-21
 * @since TODO
 */
@Aspect
@Component
public class SecondAspectJ {

    @Pointcut("execution(public * com.ofben.autordemo.spring.aop.demo11.package2.*.*(..))")
    public void pointcut2() {
    }

    @Before("pointcut2()")
    public void before2(JoinPoint joinPoint) {
        System.out.println("这是SecondAspectJ-pointcut2()-before2()实现");
    }

    @After("pointcut2()")
    public void after2() {
        System.out.println("这是SecondAspectJ-pointcut2()-after2()实现");
    }

    @AfterReturning(pointcut = "pointcut2()", returning = "retVal")
    public void afterReturning(Object retVal) {
        System.out.println("这是SecondAspectJ-pointcut2()-after2()实现:result-" + retVal);
    }
}
