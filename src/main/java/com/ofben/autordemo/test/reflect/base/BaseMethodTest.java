package com.ofben.autordemo.test.reflect.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * {@link Object}
 *
 * @date 2021-09-13
 * @since 1.0.0
 */
public class BaseMethodTest {

    public String hello = "hello";
    private String world = "world";
    public static String hello2 = "hello2";
    private static String world2 = "world2";

    public static void main(String[] args) {
        Class bClass = BaseMethodTest.class;
        BaseMethodTest bmt = new BaseMethodTest();
        // getClass
        Class bClass2 = bmt.getClass();
        System.out.println(bClass == bClass2);
        /*
        包路径	getPackage()	Package 对象	获取该类的存放路径
        类名称	getName()	String 对象	获取该类的名称
        继承类	getSuperclass()	Class 对象	获取该类继承的类
        实现接口	getlnterfaces()	Class 型数组	获取该类实现的所有接口
        构造方法	getConstructors()	Constructor 型数组	获取所有权限为 public 的构造方法
                getDeclaredContruectors()	Constructor 对象	获取当前对象的所有构造方法
        方法	getMethods()	Methods 型数组	获取所有权限为 public 的方法
                getDeclaredMethods()	Methods 对象	获取当前对象的所有方法
        成员变量	getFields()	Field 型数组	获取所有权限为 public 的成员变量
                getDeclareFileds()	Field 对象	获取当前对象的所有成员变量
        内部类	getClasses()	Class 型数组	获取所有权限为 public 的内部类
                getDeclaredClasses()	Class 型数组	获取所有内部类
        内部类的声明类	getDeclaringClass()	Class 对象	如果该类为内部类，则返回它的成员类，否则返回 null
         */
        System.out.println("包路径:" + bClass.getPackage());
        System.out.println("类名称:" + bClass.getName());
        System.out.println("继承类:" + bClass.getSuperclass());
        System.out.println("实现接口:" + bClass.getInterfaces());
        System.out.println("public构造方法:" + bClass.getConstructors().length);
        System.out.println("构造方法:" + bClass.getDeclaredConstructors().length);
        System.out.println("public方法:" + bClass.getMethods().length);
        Method[] methods = bClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
        System.out.println("方法:" + bClass.getDeclaredMethods().length);
        System.out.println("public成员变量:" + bClass.getFields().length);
        Field[] fields = bClass.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }
        System.out.println("成员变量:" + bClass.getDeclaredFields().length);
        fields = bClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }
        System.out.println("public内部类:" + bClass.getClasses());
        System.out.println("内部类:" + bClass.getDeclaredClasses());
        System.out.println("内部类的声明类:" + bClass.getDeclaringClass());

        System.out.println("------------");
        InnerClass innerClass = new InnerClass();
        Class<? extends InnerClass> aClass = innerClass.getClass();
        System.out.println("aClass:" + aClass.getDeclaringClass());
    }


    private static class InnerClass {
    }
}
