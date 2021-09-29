package com.ofben.autordemo.spring.container.imports;


import com.ofben.autordemo.spring.bean.BeanOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Bean
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
@ImportResource("classpath:/META-INF/imports/properties-config.xml")
public class AppConfig2 {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Autowired
    private BeanOne beanOne;

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        AppConfig2 appConfig = ctx.getBean(AppConfig2.class);
        System.out.println(appConfig);
        // ...
    }

    @Override
    public String toString() {
        return "AppConfig2{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", beanOne=" + beanOne +
                '}';
    }
}
