package com.ofben.autordemo.spring.aop.demo1.interceptor;

import java.lang.reflect.Method;

/**
 * 异常拦截器
 *
 * @date 2021-10-12
 * @since 1.0.0
 */
public interface ExceptionInterceptor {

    void interceptor(Object proxy, Method method, Object[] args, Throwable throwable);
}
