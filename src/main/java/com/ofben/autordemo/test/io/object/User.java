package com.ofben.autordemo.test.io.object;

import java.io.Serializable;

/**
 * Model 类
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = -2641716580127491901L;

    private Long id;

    private String name;

    private GenderEnum gender;

    private String address;

    public User() {
    }

    public User(Long id, String name, GenderEnum gender, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
