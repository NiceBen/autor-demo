package com.ofben.autordemo.spring.ioc.container.imports;

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
