package com.ofben.autordemo.test.reflect.base;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * {@link String}
 * {@link Class}
 *
 * @date 2021-09-13
 * @since 1.0.0
 */
public class StringReflectTest {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                System.out.print(Modifier.toString(m.getModifiers()));
                System.out.print(" " + m.getReturnType().getSimpleName() + " ");
                System.out.print(m.getName() + "(");

                Parameter[] parameters = m.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
                    if (i != parameters.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(");");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
