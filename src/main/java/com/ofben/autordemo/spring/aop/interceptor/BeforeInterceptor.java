package com.ofben.autordemo.spring.aop.interceptor;

import java.lang.reflect.Method;

/**
 * 前置拦截器
 *
 * @date 2021-10-12
 * @since 1.0.0
 */
public interface BeforeInterceptor {

    Object before(Object proxy, Method method, Object[] args);
}
