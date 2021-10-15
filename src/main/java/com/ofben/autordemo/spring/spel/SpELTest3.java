package com.ofben.autordemo.spring.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.GregorianCalendar;

/**
 * {@link ExpressionParser}
 * {@link SpelExpressionParser}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class SpELTest3 {

    public static void main(String[] args) {
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("name");
        String message = (String) exp.getValue(tesla);
        System.out.println(message);

        exp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(tesla, Boolean.class);
        // result == true
        System.out.println(result);
    }
}
