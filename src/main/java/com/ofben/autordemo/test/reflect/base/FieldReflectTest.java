package com.ofben.autordemo.test.reflect.base;

import com.ofben.autordemo.test.reflect.base.mock.Book2;

import java.lang.reflect.Field;

/**
 * {@link Field}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class FieldReflectTest {

    public static void main(String[] args) {
        Book2 book = new Book2();
        Class bClass = book.getClass();
        Field[] fields = bClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("成员名称：" + field.getName());
            System.out.println("类型信息：" + field.getType());

            boolean isTrue = true;
            while (isTrue) {
                try {
                    isTrue = false;
                    System.out.println("原始值：" + field.get(book));
                    Class<?> fieldType = field.getType();
                    if (fieldType.equals(int.class)) {
                        System.out.println("public - setInt:");
                        field.setInt(book, 222);
                    } else if (fieldType.equals(float.class)) {
                        System.out.println("private - setFloat:");
                        field.setFloat(book, 333.333f);
                    } else if (fieldType.equals(boolean.class)) {
                        System.out.println("protected - setBoolean:");
                        field.setBoolean(book, true);
                    } else {
                        System.out.println("set:");
                        field.set(book, "default - hello world");
                    }
                } catch (IllegalAccessException e) {
                    System.out.println("权限设置失败，通过 setAccessible() 修改权限修饰符：");
                    field.setAccessible(true);
                    isTrue = true;
                }
            }
            System.out.println("======================");
        }
        System.out.println(book);
    }
}
