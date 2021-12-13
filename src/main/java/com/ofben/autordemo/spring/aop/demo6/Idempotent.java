package com.ofben.autordemo.spring.aop.demo6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {
}
