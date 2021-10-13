package com.ofben.autordemo.spring.aop.demo2.interceptor;

import java.lang.reflect.Method;

/**
 * aop
 *
 * @date 2021-10-13
 * @since 1.0.0
 */
public class TimeFinallyInterceptor implements FinallyInterceptor {

    private final Long startTime;

    private final Long endTime;

    public TimeFinallyInterceptor(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public Object finalize(Object proxy, Method method, Object[] args, Object result) {
        return endTime - startTime;
    }
}
