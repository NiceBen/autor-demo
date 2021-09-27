package com.ofben.autordemo.spring.annotation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Bean
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix="catalog")
public class AppConfigProperties {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
