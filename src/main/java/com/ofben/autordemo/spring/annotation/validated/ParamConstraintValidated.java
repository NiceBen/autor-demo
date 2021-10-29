package com.ofben.autordemo.spring.annotation.validated;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * 验证器类
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
public class ParamConstraintValidated implements ConstraintValidator<Check, Object> {

    /**
     * 合法的参数值，从注解中获取
     */
    private List<String> paramValues;

    @Override
    public void initialize(Check constraintAnnotation) {
        // 初始化时获取注解上的值
        paramValues = Arrays.asList(constraintAnnotation.paramValues());
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (paramValues.contains(object)) {
            return true;
        }
        // 不在指定的参数列表中
        return false;
    }
}
