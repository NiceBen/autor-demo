package com.ofben.autordemo.spring.validation.databinding;

/**
 * bean
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class Employee {

    private String name;

    private float salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
