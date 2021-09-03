package com.ofben.autordemo.test.annotation.inherited;

import java.lang.annotation.*;

/**
 * {@link Inherited} test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @see Inherited
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInherited {
}
