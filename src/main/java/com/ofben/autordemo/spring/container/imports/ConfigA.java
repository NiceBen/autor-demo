package com.ofben.autordemo.spring.container.imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link A}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
//@Configuration
public class ConfigA {

//    @Bean
    public A a() {
        return new A();
    }
}
