package com.ofben.autordemo.spring.aop.interceptor;

import java.lang.reflect.Method;

/**
 * 异常拦截器
 *
 * @date 2021-10-12
 * @since 1.0.0
 */
public interface FinallyInterceptor {

    Object finalize(Object proxy, Method method, Object[] args, Object result);
}
