package com.ofben.autordemo.spring.ioc.path.named;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * {@link ScopeMetadataResolver}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
public class MyScopeResolver implements ScopeMetadataResolver {
    @Override
    public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
        ScopeMetadata metadata = new ScopeMetadata();
        if ((ConfigurableBeanFactory.SCOPE_PROTOTYPE).equals(definition.getScope())) {
            metadata.setScopeName(ConfigurableBeanFactory.SCOPE_PROTOTYPE);
            metadata.setScopedProxyMode(ScopedProxyMode.NO);
        }
        return metadata;
    }
}
