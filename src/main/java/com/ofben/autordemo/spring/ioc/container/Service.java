package com.ofben.autordemo.spring.ioc.container;

/**
 * {@link UserPreferences}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public class Service {

    private UserPreferences userPreferences;

    public void setUserPreferences(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }
}
