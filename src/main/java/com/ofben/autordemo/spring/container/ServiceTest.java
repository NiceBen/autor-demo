package com.ofben.autordemo.spring.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.inject.Inject;

/**
 * {@link Service}
 * {@link UserPreferences}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
public class ServiceTest {

    @Inject
    private UserPreferences preferences;

    @Bean
    @Description("this bean description")
//    @SessionScope
//    @Scope("prototype")
    public UserPreferences userPreferences() {
        return new UserPreferences();
    }

    @Bean
    public Service service() {
        Service service = new Service();
        service.setUserPreferences(userPreferences());
        System.out.println(preferences);
        System.out.println(userPreferences());
        return service;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ServiceTest.class);
    }
}
