package com.ofben.autordemo.spring.ioc.environment;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Map;
import java.util.Properties;

/**
 * {@link PropertySource}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class MyPropertySource extends MapPropertySource {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public MyPropertySource(String name, Properties source) {
        super(name, (Map) source);
    }

    public Object getProperty() {
        return super.getPropertyNames();
    }
}
