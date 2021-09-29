package com.ofben.autordemo.spring.container;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * {@link TransferService}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
public class TransferServiceTest implements InitializingBean, DisposableBean, Lifecycle,
        BeanFactoryAware, BeanNameAware, MessageSourceAware, ApplicationContextAware {

    public void initMethod() {
        System.out.println("initMethod()");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod()");
    }


    @PostConstruct
    public void init() {
        // 1
        System.out.println("init()");
    }

    @PreDestroy
    public void clear() {
        // 3
        System.out.println("clear()");
    }

    @Bean
    public TransferService transferService(AccountRepository repository) {
        return new TransferServiceImpl();
    }

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.scan("com.ofben.autordemo.spring.container");
//        context.refresh();
//        context.close();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/container/app-config.xml");
        context.close();
    }

    @Override
    public void destroy() throws Exception {
        // 4
        System.out.println("destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 2
        System.out.println("afterPropertiesSet()");
    }

    @Override
    public void start() {
        System.out.println("start()");
    }

    @Override
    public void stop() {
        System.out.println("stop()");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory()");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext()");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("setMessageSource()");
    }
}
