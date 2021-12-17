package com.ofben.autordemo.spring.aopapi;

/**
 * TODO
 *
 * @date 2021-12-17
 * @since TODO
 */
public class MainBoot {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        new Thread(() -> {
            person.setName("zhangsan");
            person.setAge(11);
            System.out.println("当前线程1-睡眠前：" + Thread.currentThread().getName()
                    + "，姓名：" + person.getName() + "，年龄:" + person.getAge());
            try {
                Thread.sleep(1000 * 10);
                System.out.println("当前线程-睡眠后：" + Thread.currentThread().getName()
                        + "，姓名：" + person.getName() + "，年龄:" + person.getAge());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000 * 3);
        new Thread(() -> {
            person.setName("lisi");
            person.setAge(22);
            System.out.println("当前线程2-修改后：" + Thread.currentThread().getName()
                    + "，姓名：" + person.getName() + "，年龄:" + person.getAge());
        }).start();
    }

    static class Person {
        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
