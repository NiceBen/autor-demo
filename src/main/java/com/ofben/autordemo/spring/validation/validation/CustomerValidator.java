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
public class CustomerValidator implements Validator {

    private final Validator personValidator;

    public CustomerValidator(Validator personValidator) {
        if (personValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is " +
                    "required and must not be null.");
        }
        if (!personValidator.supports(Person.class)) {
            throw new IllegalArgumentException("The supplied [Validator] must " +
                    "support the validation of [Address] instances.");
        }
        this.personValidator = personValidator;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "filed.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "filed.required");
        Customer customer = (Customer) target;
        try {
            errors.pushNestedPath("person");
            ValidationUtils.invokeValidator(this.personValidator, customer.getPerson(), errors);
        } finally {
            errors.popNestedPath();
        }
    }
}
