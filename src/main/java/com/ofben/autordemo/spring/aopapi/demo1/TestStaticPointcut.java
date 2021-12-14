package com.ofben.autordemo.spring.aopapi.demo1;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @date 2021-12-14
 * @since TODO
 */
public class TestStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return false;
    }
}
