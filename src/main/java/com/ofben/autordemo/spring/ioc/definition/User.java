package com.ofben.autordemo.spring.ioc.definition;

/**
 * User
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class User {

    private String name;

    private int age;

    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
