package com.ofben.autordemo.spring.aop.demo5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Component
@Aspect
public class SampleAspectJ {

    @Before("execution(* ..Sample+.sampleGenericMethod(*)) && args(param)")
    public void beforeSampleMethod(MyType param) {
        //

    }

    @Before("execution(* ..Sample+.sampleGenericCollectionMethod(*)) && args(param)")
    public void beforeSampleMethod(Collection<?> param) {
        // Advice implementation
    }


}
