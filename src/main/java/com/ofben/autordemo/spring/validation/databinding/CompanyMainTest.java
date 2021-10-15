package com.ofben.autordemo.spring.validation.databinding;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * {@link BeanWrapper}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class CompanyMainTest {

    public static void main(String[] args) {
        BeanWrapper company = new BeanWrapperImpl(new Company());
        // setting the company name..
        company.setPropertyValue("name", "Some Company Inc.");
        // ... can also be done like this:
        PropertyValue value = new PropertyValue("name", "Som Company Inc.");
        company.setPropertyValue(value);

        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        System.out.println(salary);
    }
}
