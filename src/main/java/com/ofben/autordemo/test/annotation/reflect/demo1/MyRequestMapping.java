package com.ofben.autordemo.test.annotation.reflect.demo1;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

/**
 * {@link RequestMapping} test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {

    // 这是注解的一个属性字段，也就是在使用注解时填写在括号里的参数
    String value();
}
