package com.ofben.autordemo.test.annotation.reflect.demo2;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @date 2021-09-03
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {
    String value();
}
