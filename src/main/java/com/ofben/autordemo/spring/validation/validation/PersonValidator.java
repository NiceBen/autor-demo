package com.ofben.autordemo.spring.validation.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * {@link Validator}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class PersonValidator implements Validator {

    /**
     * This Validator validates only Person instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "age to small");
        } else if (p.getAge() > 10) {
            errors.rejectValue("age", "age to big");
        }
    }
}
