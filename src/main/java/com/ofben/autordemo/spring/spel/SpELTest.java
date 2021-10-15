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
public class SpELTest {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}
