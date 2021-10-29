package com.ofben.autordemo.spring.annotation.validated;

/**
 * 参数
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class User {

    // 姓名
    private String name;

    // 性别
    @Check(paramValues = {"man", "woman"})
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
