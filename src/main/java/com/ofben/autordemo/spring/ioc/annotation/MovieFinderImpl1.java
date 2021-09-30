package com.ofben.autordemo.spring.ioc.annotation;

import org.springframework.core.annotation.Order;

import javax.annotation.Priority;

/**
 * Bean
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Order(1)
@Priority(1)
public class MovieFinderImpl1 extends MovieFinder {
}
