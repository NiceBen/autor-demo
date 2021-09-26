package com.ofben.autordemo.spring.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * {@link CommandManager2}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class CommandManager2Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/commandManager2.xml");
        context.refresh();

        CommandManager2 commandManager = context.getBean("commandManager", CommandManager2.class);
        commandManager.process(new HashMap());

        context.close();
    }
}
