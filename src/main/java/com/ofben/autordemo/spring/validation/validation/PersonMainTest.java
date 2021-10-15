package com.ofben.autordemo.spring.validation.validation;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * {@link Person}
 * {@link Validator}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class PersonMainTest {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(99);

        PersonValidator pv = new PersonValidator();
        if (pv.supports(p.getClass())) {
            Errors errors = new BindException(p, "person1");

            pv.validate(p, errors);

            List<ObjectError> allErrors = errors.getAllErrors();
            allErrors.forEach(e -> System.out.println(e));
        }
    }
}
