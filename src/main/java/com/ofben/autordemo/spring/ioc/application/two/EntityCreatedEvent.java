package com.ofben.autordemo.spring.ioc.application.two;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * Bean
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class EntityCreatedEvent<T>  extends ApplicationEvent implements ResolvableTypeProvider {
    private static final long serialVersionUID = 475463382281809612L;

    private final T t;

    public EntityCreatedEvent(Object source, T t) {
        super(source);
        this.t = t;
    }

    public T getT() {
        return t;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
    }
}