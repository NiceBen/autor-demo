package com.ofben.autordemo.spring.validation.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * {@link Validator}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class FooValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        if (Foo.class.equals(clazz)) {
            return true;
        }
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (Foo.class.isAssignableFrom(target.getClass())) {
            Foo foo = (Foo) target;
            String name = foo.getName();
            int age = foo.getAge();

            if (StringUtils.isEmpty(name)) {
                errors.rejectValue("name", "name 为空！");
            }

            if (name.length() < 5 || name.length() > 20) {
                errors.rejectValue("name", "name 长度不符合标准！");
            }

            if (age < 10) {
                errors.rejectValue("age", "age 过小！");
            }
        }
    }
}
