package com.ofben.autordemo.spring.ioc.environment;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * {@link MessageSource}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class Example {

    private MessageSource messages;

    public void setMessages(MessageSource messages) {
        this.messages = messages;
    }

    public void execute() {
        this.messages.getMessage("argument.required", new Object[]{"userDao"}, "Required", Locale.ENGLISH);
        System.out.println(messages);
    }

    public static void main(final String[] args) {
        MessageSource resources = new ClassPathXmlApplicationContext("META-INF/environment/beans2.xml");
        String message = resources.getMessage("argument.required",
                new Object [] {"userDao"}, "Required", Locale.UK);
        System.out.println(message);
    }
}
