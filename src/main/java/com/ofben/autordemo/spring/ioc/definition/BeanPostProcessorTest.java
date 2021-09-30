package com.ofben.autordemo.spring.ioc.definition;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link BeanPostProcessor}
 *
 * @date 2021-09-26
 * @see BeanPostProcessor
 * @since 1.0.0
 */
public class BeanPostProcessorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.addBeanPostProcessor(new SecondBeanPostProcessor());
//        beanFactory.addBeanPostProcessor(new FirstBeanPostProcessor());
        context.register(BeanPostProcessorTest.class);
        context.refresh();

        BeanPostProcessorTest bean = context.getBean(BeanPostProcessorTest.class);

        context.close();
    }

}
