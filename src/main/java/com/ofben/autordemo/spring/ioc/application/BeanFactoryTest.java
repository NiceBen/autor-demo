package com.ofben.autordemo.spring.ioc.application;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

/**
 * {@link BeanFactory}
 * {@link XmlBeanDefinitionReader}
 * {@link PropertySourcesPlaceholderConfigurer}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new FileSystemResource("bean.xml"));

        PropertySourcesPlaceholderConfigurer cfg = new PropertySourcesPlaceholderConfigurer();
        cfg.setLocation(new FileSystemResource("jdbc.properties"));

        cfg.postProcessBeanFactory(beanFactory);
    }
}
