package com.ofben.autordemo.spring.validation.typeconversion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.time.format.DateTimeFormatter;
import org.springframework.format.datetime.DateFormatter;

/**
 * {@link DateTimeFormatterRegistrar}
 * {@link DateFormatterRegistrar}
 * 自定义全局的日期转换类
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
@Configuration
public class CustomGlobalDateTimeFormat {

    @Bean
    public FormattingConversionService conversionService() {
        // Use the default DefaultFormattingConversionService but do not register default
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        // Ensure @NumberFormat is still supported
        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());

        // Register JSR-310 date conversion with a specific global format
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DateTimeFormatter.ofPattern("yyyyMMdd"));
        registrar.registerFormatters(conversionService);

        // Register date conversion with a specific global format
        DateFormatterRegistrar registrar1 = new DateFormatterRegistrar();
        registrar1.setFormatter(new DateFormatter("yyyyMMdd"));
        registrar1.registerFormatters(conversionService);

        return conversionService;
    }
}
