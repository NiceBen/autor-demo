package com.ofben.autordemo.optimize.usertest;

import java.io.Serializable;
import java.util.Objects;

/**
 * 具体业务对象
 *
 * @date 2021-08-27
 * @since 1.0.0
 */
public class UserModel implements Serializable {

    private String userId = "";

    private String name = "";

    private int age = 0;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserModel userModel = (UserModel) object;
        return age == userModel.age &&
                userId.equals(userModel.userId) &&
                name.equals(userModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, age);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
