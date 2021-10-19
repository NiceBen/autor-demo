package com.ofben.autordemo.spring.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect
 *
 * @date 2021-10-19
 * @since 1.0.0
 */
@Aspect
public class NotVeryUsefulAspect {


//    @Pointcut("execution(public * com.deo.controller.android..*.*(..))")
//    @Pointcut("execution(public * com.deo.service.*.*.*(..)) && @annotation(com.deo.annotations.TokenValidate)")
    @Pointcut("execution(* transfer(..))")
    public void anyOldTransfer(){}

    @Pointcut("execution(public * *(..))")
    public void anyPublicOperation(){}

    @Pointcut("within(com.ofben.autordemo.spring.aop.config..*)")
    public void inTrading(){}

    @Pointcut("anyPublicOperation() && inTrading()")
    public void tradingOperation(){}





}
