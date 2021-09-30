package com.ofben.autordemo.spring.ioc.environment;

import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.*;

/**
 * {@link PropertySource}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@PropertySource(value = "classpath:/META-INF/environment/app-property-source.properties")
@PropertySource(value = "classpath:/META-INF/${testbean.path:hello}/app-property-source2.properties")
public @interface MyPropertySources {
}
