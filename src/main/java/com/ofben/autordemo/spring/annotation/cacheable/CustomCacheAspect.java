package com.ofben.autordemo.spring.annotation.cacheable;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 方面
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@Aspect
@Component
public class CustomCacheAspect {

//    @Pointcut("@annotation(com.ofben.autordemo.spring.annotation.cacheable.CustomCache) && @annotation(CustomCache)")
//    public void cutCache() {
//    }

    /**
     * 在方法执行之前对注解进行处理
     * @param pjd
     * @param customCache   注解
     * @return              返回中的值
     */
    @Around("@annotation(com.ofben.autordemo.spring.annotation.cacheable.CustomCache) && @annotation(customCache)")
    public Object dealProcess(ProceedingJoinPoint pjd, CustomCache customCache) {
        Object result = null;

        if (customCache.key() == null) {
            // TODO throw error
        }

        // TODO 业务场景会比这个复杂的多，会涉及参数的解析如 key 可能是 #{id} 这些，数据查询
        // TODO 这里简单演示，如果 key 为 testKey 则返回 hello world
        if ("testKey".equals(customCache.key())) {
            return "hello world";
        }

        // 执行目标方法
        try {
            result = pjd.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }
}
