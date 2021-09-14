package com.ofben.autordemo.test.reflect.demo;

import java.lang.reflect.Method;

/**
 * {@link Method}
 * {@link Student}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class MethodTest {

    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class<?> aClass = Class.forName("com.ofben.autordemo.test.reflect.demo.Student");

        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");
        Method[] methods = aClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }


        System.out.println("***************获取所有的方法，包括私有的*******************");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }


        System.out.println("***************获取公有的show1()方法*******************");
        Method show1 = aClass.getMethod("show1", String.class);
        System.out.println(show1);
        //实例化一个Student对象
        Object obj = aClass.getConstructor().newInstance();
        show1.invoke(obj, "hello");


        System.out.println("***************获取私有的show4()方法******************");
        Method show4 = aClass.getDeclaredMethod("show4", int.class);
        System.out.println(show4);
        show4.setAccessible(true);
        Object result = show4.invoke(obj, 222);
        System.out.println("返回值：" + result);
    }
}
