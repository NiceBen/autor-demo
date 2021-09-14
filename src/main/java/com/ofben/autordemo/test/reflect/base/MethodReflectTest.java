package com.ofben.autordemo.test.reflect.base;

import com.ofben.autordemo.test.reflect.base.mock.Book1;

import java.lang.reflect.Method;

/**
 * {@link Method}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class MethodReflectTest {

    public static void main(String[] args) {
        Book1 book = new Book1();
        Class bClass = book.getClass();
        Method[] methods = bClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("方法名为：" + method.getName());
            System.out.println("是否带可变类型参数：" + method.isVarArgs());
            System.out.println("入参参数类型：");
            Class<?>[] pTypes = method.getParameterTypes();
            for (int j = 0; j < pTypes.length; j++) {
                System.out.println("第" + (j + 1) + "个参数，类型为：" + pTypes[j].getName());
            }
            Class<?>[] eTypes = method.getExceptionTypes();
            for (int j = 0; j < eTypes.length; j++) {
                System.out.println("第" + (j + 1) + "个参数，类型为：" + eTypes[j].getName());
            }
            Class<?> returnType = method.getReturnType();
            System.out.println("返回值类型：" + returnType.getName());

            System.out.println("----------------");

            boolean isTrue = true;
            while (isTrue) {
                try {
                    isTrue = false;
                    switch (method.getName()) {
                        case "staticMethod":
                            method.invoke(book);
                            break;
                        case "publicMethod":
                            System.out.println("publicMethod(10)返回结果为：" + method.invoke(book, 10));
                            break;
                        case "protectedMethod":
                            System.out.println("protectedMethod(\"10\", 15)返回结果为：" + method.invoke(book,"10", 15));
                            break;
                        case "privateMethod":
                            Object[] parameters = {new String[]{"J", "A", "V", "A"}};
                            System.out.println("privateMethod()可变数组返回结果为：" + method.invoke(book, parameters));
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("在设置成员变量值时抛出异常，下面执行setAccessible()方法");
                    method.setAccessible(true);
                    isTrue = true;
                }
            }
            System.out.println("==================");
        }
    }
}
