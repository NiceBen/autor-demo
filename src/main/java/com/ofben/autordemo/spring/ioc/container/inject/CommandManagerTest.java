package com.ofben.autordemo.spring.ioc.container.inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * {@link Command}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public class CommandManagerTest {

    @Bean
    @Scope("prototype")
    public AsyncCommand asyncCommand() {
        AsyncCommand command = new AsyncCommand();
        return command;
    }

    @Bean("manager")
    public CommandManager commandManager() {
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                return asyncCommand();
            }
        };
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CommandManagerTest.class);
        CommandManager manager = context.getBean(CommandManager.class);
        CommandManager manager2 = context.getBean(CommandManager.class);
        System.out.println(manager.process(null));
    }
}
