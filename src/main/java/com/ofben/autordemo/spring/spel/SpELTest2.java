package com.ofben.autordemo.spring.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * {@link ExpressionParser}
 * {@link SpelExpressionParser}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class SpELTest2 {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();


        String elString = "'Hello World'.bytes";
        String elString2 = "new String('hello world').toUpperCase()";

        Expression exp = parser.parseExpression(elString2);
        String message = exp.getValue(String.class);
        System.out.println(message);
    }
}
