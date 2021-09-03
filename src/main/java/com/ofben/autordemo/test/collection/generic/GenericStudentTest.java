package com.ofben.autordemo.test.collection.generic;

/**
 * {@link GenericStudent} Test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class GenericStudentTest {

    public static void main(String[] args) {
        testGenericGroup1();
        System.out.println("----------------");
        testGenericGroup2();
    }

    private static void testGenericGroup2() {
        GenericStudent<Integer, Integer, Integer> stu = new GenericStudent<>(5, 5, 5);
        Integer name = stu.getName();
        Integer age = stu.getAge();
        Integer sex = stu.getSex();
        System.out.println("学生信息如下：");
        System.out.println("学生姓名：" + name + ", 年龄：" + age + ", 性别：" + age);
    }

    private static void testGenericGroup1() {
        GenericStudent<String, Integer, Character> student = new GenericStudent<>("zhangsan", 23, '女');
        String name = student.getName();
        Integer age = student.getAge();
        Character sex = student.getSex();
        System.out.println("学生信息如下：");
        System.out.println("学生姓名：" + name + ", 年龄：" + age + ", 性别：" + age);
    }
}
