package com.ofben.autordemo.spring.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class TaxCalculator {

    private String defaultLocale;

    private float initialShapeSeed;

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public void setInitialShapeSeed(float initialShapeSeed) {
        this.initialShapeSeed = initialShapeSeed;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spel/number-guess.xml");
        TaxCalculator bean = context.getBean(TaxCalculator.class);
        System.out.println(bean.defaultLocale);
        System.out.println(bean.initialShapeSeed);
    }
}
