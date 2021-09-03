package com.ofben.autordemo.test.annotation.reflect.demo1;

/**
 * {@link MyRequestMapping}
 * {@link TestController}
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Class<?> c = TestController.class;
        MyRequestMapping baseRequestMapping = c.getAnnotation(MyRequestMapping.class);
        // 输出 value 的值
        System.out.println(baseRequestMapping.value());
    }
}
