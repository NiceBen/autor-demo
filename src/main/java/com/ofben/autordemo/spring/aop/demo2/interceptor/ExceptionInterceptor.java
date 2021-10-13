package com.ofben.autordemo.spring.aop.demo2.interceptor;

import java.lang.reflect.Method;

/**
 * aop
 *
 * @date 2021-10-13
 * @since 1.0.0
 */
public interface ExceptionInterceptor {

    void interceptor(Object proxy, Method method, Object[] args, Exception e);
}
