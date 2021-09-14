package com.ofben.autordemo.test.reflect.demo;

import javax.print.attribute.standard.Fidelity;
import java.lang.reflect.Field;

/**
 * {@link Field}
 * {@link Student}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class FieldsTest {

    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class<?> aClass = Class.forName("com.ofben.autordemo.test.reflect.demo.Student");

        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }


        System.out.println("*************获取公有字段**并调用***********************************");
        Field name = aClass.getField("name");
        System.out.println(name);
        //获取一个对象
        Object obj = aClass.getConstructor().newInstance();
        //为字段设置值
        name.set(obj, "hello");

        //验证
        Student stu = (Student)obj;
        System.out.println("验证姓名：" + stu.name);


        System.out.println("**************获取私有字段****并调用********************************");
        Field phoneNum = aClass.getDeclaredField("phoneNum");
        phoneNum.setAccessible(true);
        phoneNum.set(obj, "131313131");

        System.out.println("phoneNum：" + stu);


    }
}
