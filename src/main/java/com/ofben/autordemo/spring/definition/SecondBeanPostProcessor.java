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
public class SecondBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanPostProcessorTest) {
            System.out.println("SecondBeanPostProcessor-postProcessBeforeInitialization-" + beanName);
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanPostProcessorTest) {
            System.out.println("SecondBeanPostProcessor-postProcessAfterInitialization-" + beanName);
        }
        return null;
    }
}
