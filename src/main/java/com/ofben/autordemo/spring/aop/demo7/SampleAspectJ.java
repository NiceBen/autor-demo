package com.ofben.autordemo.spring.aop.demo7;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.dao.DataAccessException;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
public class SampleAspectJ {

    public void doAccessCheck() {
        System.out.println("before");
    }

    public void doAccessCheck2(Object retVal) {
        System.out.println("afterReturning");
    }

    public void doRecoveryActions(DataAccessException dataAccessEx) {
        System.out.println("afterException");
    }

    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }
}
