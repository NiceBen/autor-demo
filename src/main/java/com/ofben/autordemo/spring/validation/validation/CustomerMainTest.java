package com.ofben.autordemo.spring.validation.validation;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * {@link Customer}
 * {@link CustomerValidator}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class CustomerMainTest {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Person person = new Person();
        person.setAge(99);
        customer.setPerson(person);

        PersonValidator personValidator = new PersonValidator();
        CustomerValidator customerValidator = new CustomerValidator(personValidator);

        if (customerValidator.supports(customer.getClass())) {
            Errors errors = new BindException(customer, "customer");
            customerValidator.validate(customer, errors);
            List<ObjectError> allErrors = errors.getAllErrors();
            allErrors.forEach(System.out::println);
        }
    }
}
