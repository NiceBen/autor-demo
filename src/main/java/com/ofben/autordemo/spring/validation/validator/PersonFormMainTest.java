package com.ofben.autordemo.spring.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * {@link javax.validation.Validator}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
@Configuration
public class PersonFormMainTest {

    @Autowired
    private PersonForm personForm;

    @Bean
    public PersonForm personForm() {
        PersonForm personForm = new PersonForm();
        personForm.setAge(-11);
        return personForm;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MethodValidationPostProcessor validationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonFormMainTest.class);
        PersonForm bean = context.getBean(PersonForm.class);
        System.out.println(bean);
        System.out.println("-----------");
        PersonFormMainTest test = context.getBean(PersonFormMainTest.class);
        System.out.println(test.personForm);
    }
}
