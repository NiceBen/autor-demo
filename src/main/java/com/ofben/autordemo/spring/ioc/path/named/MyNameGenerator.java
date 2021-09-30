package com.ofben.autordemo.spring.ioc.path.named;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

import java.util.UUID;

/**
 * {@link BeanNameGenerator}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
public class MyNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return UUID.randomUUID().toString();
    }
}
