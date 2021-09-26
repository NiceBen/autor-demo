package com.ofben.autordemo.spring.definition;

import org.springframework.beans.factory.FactoryBean;

/**
 * {@link FactoryBean}
 * {@link User}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setName("lisa");
        user.setAge(18);
        user.setAddress("BEIJING");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
