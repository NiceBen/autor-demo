package com.ofben.autordemo.spring.ioc.annotation;

import org.springframework.core.convert.converter.Converter;

/**
 * {@link Converter}
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
public class MyConverter implements Converter {

    /**
     * 如果是字符串，就转换成字符串数组
     * @param source        源参数
     * @return              调整后的参数类型
     */
    @Override
    public Object convert(Object source) {
        if (source instanceof String) {
            String str = (String) source;
            String[] arr = new String[]{str};
            return arr;
        }
        return source;
    }
}
