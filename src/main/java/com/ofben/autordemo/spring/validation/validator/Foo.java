package com.ofben.autordemo.spring.validation.validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Bean
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class Foo {

    @NotNull
    @Size(max = 20, min = 5)
    private String name;

    @Min(10)
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
