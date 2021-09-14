package com.ofben.autordemo.test.reflect.demo;

import java.lang.reflect.Constructor;

/**
 * {@link Constructor}
 * {@link Student}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class ConstructorsTest {

    public static void main(String[] args) throws Exception {
        //1.加载Class对象
        Class<?> aClass = Class.forName("com.ofben.autordemo.test.reflect.demo.Student");


        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName());
        }


        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }


        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor<?> constructor = aClass.getConstructor(null);
        System.out.println(constructor);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。
        //调用构造方法
        Student student = (Student) constructor.newInstance();


        System.out.println("******************获取私有构造方法，并调用*******************************");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(char.class);
        System.out.println(declaredConstructor);
        //调用构造方法
        declaredConstructor.setAccessible(true);
        Object instance = declaredConstructor.newInstance('男');
        System.out.println(instance);
    }
}
