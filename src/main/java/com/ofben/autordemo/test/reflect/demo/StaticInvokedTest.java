package com.ofben.autordemo.test.reflect.demo;

import java.lang.reflect.Method;

/**
 * {@link Method}
 * {@link Student}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class StaticInvokedTest {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.ofben.autordemo.test.reflect.demo.Student");

        Method main = aClass.getMethod("main", String[].class);

        main.invoke(null, (Object) new String[]{"hello", "world", "welcome"});
    }
}
