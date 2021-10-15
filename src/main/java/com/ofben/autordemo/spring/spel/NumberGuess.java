package com.ofben.autordemo.spring.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class NumberGuess {

    private float randomNumber;

    public void setRandomNumber(float randomNumber) {
        this.randomNumber = randomNumber;
    }

    public float getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spel/number-guess.xml");
        NumberGuess bean = context.getBean(NumberGuess.class);
        System.out.println(bean.randomNumber);
    }
}
