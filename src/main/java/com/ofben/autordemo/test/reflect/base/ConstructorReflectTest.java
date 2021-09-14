package com.ofben.autordemo.test.reflect.base;

import com.ofben.autordemo.test.reflect.base.mock.Book;

import java.lang.reflect.Constructor;

/**
 * {@link Class}
 * {@link Constructor}
 *
 * @date 2021-09-13
 * @since 1.0.0
 */
public class ConstructorReflectTest {
    /*
    http://c.biancheng.net/view/1109.html
     */

    public static void main(String[] args) {
        // 获取动态类 Book
        Class bClass = Book.class;
        // 获取所有的构造方法
        Constructor[] cons = bClass.getDeclaredConstructors();

        for (int i = 0; i < cons.length; i++) {
            System.out.println("是否带可变参数：" + cons[i].isVarArgs());
            System.out.println("入参参数类型：");
            Class[] parameterTypes = cons[i].getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println("第"+ (j+1) + "个参数类型为：" + parameterTypes[j].getName());
            }
            Class[] exceptionTypes = cons[i].getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println("第"+ (j+1) + "个异常类型为：" + exceptionTypes[j].getName());
            }
            System.out.println("------------------");

            // 创建一个未实例化的 Book 类实例
            Book book1 = null;
            int index = 1;
            while (book1 == null) {
                cons[i].setAccessible(true);
                // 如果该成员变量的访问权限为 private，则抛出异常
                try {
                    if (index == 1) {
                        // 通过执行带两个参数的构造方法实例化 book1
                        book1 = (Book) cons[i].newInstance(10, "hello");
                    } else if (index == 2) {
                        // 通过执行默认构造方法实例化book1
                        book1 = (Book) cons[i].newInstance();
                    } else {
                        // 通过执行可变数量参数的构造方法实例化 book1
                        Object[] parameters = new Object[]{new String[]{"100", "200"}};
                        book1 = (Book) cons[i].newInstance(parameters);
                    }
                } catch (Exception e) {
                    System.out.println("在创建对象时抛出异常，下面执行 setAccessible() 方法");
                    // 设置允许访问 private 成员
                    cons[i].setAccessible(true);
                    // 累计增长下标
                    index++;
                }
            }
            System.out.println(book1);
            System.out.println("========================\n");
        }
    }
}
