package com.ofben.autordemo.spring.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * {@link ConstraintValidator}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {
   public void initialize(MyConstraint constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return false;
   }
}
