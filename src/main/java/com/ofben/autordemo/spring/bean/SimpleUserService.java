package com.ofben.autordemo.spring.bean;

/**
 * Bean
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class SimpleUserService {

    private UserPreferences userPreferences;

    private UserPreferences2 userPreferences2;

    public void setUserPreferences(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    public void setUserPreferences2(UserPreferences2 userPreferences2) {
        this.userPreferences2 = userPreferences2;
    }

    public UserPreferences getUserPreferences() {
        return userPreferences;
    }
}
