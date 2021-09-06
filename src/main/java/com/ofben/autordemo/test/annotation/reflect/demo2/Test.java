package com.ofben.autordemo.test.annotation.reflect.demo2;

import java.lang.annotation.Annotation;

/**
 * TODO
 *
 * @date 2021-09-03
 * @since TODO
 */
public class Test {

    public static void main(String[] args) {
        Class<?> c = TestController.class;
        Annotation[] atnsArray = c.getAnnotations();
        for (Annotation an : atnsArray) {
            System.out.println(an);
        }
    }
}
