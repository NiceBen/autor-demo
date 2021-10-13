package com.ofben.autordemo.spring.aop.demo1.interceptor;

import java.lang.reflect.Method;

/**
 * {@link FinallyInterceptor}
 *
 * @date 2021-10-12
 * @since 1.0.0
 */
public class TimeFinallyInterceptor implements FinallyInterceptor {

    private Long startTime;

    private Long endTime;

    public TimeFinallyInterceptor(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public Object finalize(Object proxy, Method method, Object[] args, Object result) {
        // 方法执行时间（毫秒）
        return endTime - startTime;
    }
}
