package com.ofben.autordemo.spring.ioc.bean;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * {@link Scope} 动态扩展 Scope 范围
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class MyScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = objectFactory.getObject();
        return null;
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
