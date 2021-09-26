package com.ofben.autordemo.spring.definition;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * {@link PropertyOverrideConfigurer}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class PropertyOverrideConfigurerTest {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/definition/propertyOverrideConfigurer.xml");

        BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        System.out.println(dataSource);
        System.out.println(dataSource.getDriverClassName());
        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getUsername());
        System.out.println(dataSource.getPassword());


//        context.refresh();
        context.close();
    }
}
