package com.ofben.autordemo.spring.definition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * {@link BeanPostProcessor}
 * {@link Ordered}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class FirstBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("FirstBeanPostProcessor-postProcessBeforeInitialization-" + beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("FirstBeanPostProcessor-postProcessAfterInitialization-" + beanName);
        return null;
    }
}
