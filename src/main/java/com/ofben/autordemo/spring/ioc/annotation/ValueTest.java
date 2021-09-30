package com.ofben.autordemo.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Value
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Component
public class ValueTest {

    private final String catalog;

    public ValueTest(@Value("${catalog.name}") String catalog) {
        this.catalog = catalog;
    }
}
