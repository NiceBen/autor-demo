package com.ofben.autordemo.spring.validation.typeconversion;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * {@link ConversionService}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
@Component
public class MyService {

    private final ConversionService conversionService;

    public MyService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public void doIt() {
        this.conversionService.convert("123", Integer.class);
    }
}
