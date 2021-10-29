package com.ofben.autordemo.spring.annotation.cacheable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存
 *
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionCheck {

    /**
     * 资源key
     */
    String resourceKey();
}
