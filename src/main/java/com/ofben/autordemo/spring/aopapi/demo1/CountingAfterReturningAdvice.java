package com.ofben.autordemo.spring.aopapi.demo1;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @date 2021-12-14
 * @since TODO
 */
public class CountingAfterReturningAdvice implements AfterReturningAdvice {

    private int count;

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        ++count;
    }

    public int getCount() {
        return count;
    }
}
