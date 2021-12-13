package com.ofben.autordemo.spring.aop.demo6;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Component
@Aspect
public class ConcurrentOperationExecutor implements Ordered {

    // 定义最大重试次数
    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;
    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

//    @Around(value = "com.ofben.autordemo.spring.aop.demo6.CommonPointcuts.businessService()")
//    @Around("com.ofben.autordemo.spring.aop.demo6.CommonPointcuts.businessService() && " +
//            "@annotation(com.ofben.autordemo.spring.aop.demo6.Idempotent)")
    @Around("@annotation(com.ofben.autordemo.spring.aop.demo6.Idempotent)")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int numAttempts = 0;
        PessimisticLockingFailureException lockingFailureException;
        do {
            numAttempts++;
            try {
                System.out.println("numAttempts:" + numAttempts);
                return pjp.proceed();
            } catch (PessimisticLockingFailureException ex) {
                lockingFailureException = ex;
            }
        } while (numAttempts <= this.maxRetries);
        throw lockingFailureException;
    }
}
