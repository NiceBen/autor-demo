package com.ofben.autordemo.test.reflect.demo;

/**
 * {@link Student}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class ClassTest {

    public static void main(String[] args) {
        //1. get Class
        Student student = new Student();
        Class<? extends Student> clazz1 = student.getClass();

        //2. get Class
        Class<Student> clazz2 = Student.class;
        System.out.println(clazz1 == clazz2);

        //3. get Class
        try {
            Class<?> clazz3 = Class.forName("com.ofben.autordemo.test.reflect.demo.Student");
            System.out.println(clazz2 == clazz3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
