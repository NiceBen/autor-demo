package com.ofben.autordemo.spring.validation.databinding;

/**
 * Bean
 * {@link Employee}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class Company {

    private String name;

    private Employee managingDirector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManagingDirector() {
        return managingDirector;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }
}
