package com.ofben.autordemo.spring.validation.validator;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * {@link DataBinder}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class FooDataBinderMainTest {

    public static void main(String[] args) {
        Foo target = new Foo();
        DataBinder binder = new DataBinder(target);
        binder.setValidator(new FooValidator());

        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("name", "hell");
        pvs.add("age", 8);

        binder.bind(pvs);

        binder.validate();

        BindingResult bindingResult = binder.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        allErrors.forEach(objectError -> System.out.println(objectError.getCode()));
    }
}
