package com.ofben.autordemo.spring.aopapi.demo1;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @date 2021-12-14
 * @since TODO
 */
public class CountingBeforeAdvice implements MethodBeforeAdvice {
    private int count;

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        ++count;
    }

    public int getCount() {
        return count;
    }
}
