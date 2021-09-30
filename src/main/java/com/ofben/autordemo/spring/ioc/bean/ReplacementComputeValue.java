package com.ofben.autordemo.spring.ioc.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * {@link MethodReplacer}
 *
 * @date 2021-09-26
 * @see MethodReplacer
 * @since 1.0.0
 */
public class ReplacementComputeValue implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        String input = (String) args[0];
        return input + " world";
    }
}
