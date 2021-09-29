package com.ofben.autordemo.spring.container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Bean
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
public class MyConfiguration {

    @Bean
    @Scope("prototype")
    public Encryptor encryptor() {
        return new Encryptor();
    }
}
