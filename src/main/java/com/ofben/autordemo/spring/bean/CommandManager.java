package com.ofben.autordemo.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * {@link ApplicationContextAware}
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public class CommandManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CommandManager.class);
        context.refresh();

        CommandManager bean = context.getBean(CommandManager.class);
        System.out.println(bean.applicationContext);

        context.close();
    }

    public Object process(Map commandState) {
        Command command = createCommand();
        command.setState(commandState);
        return command.execute();
    }

    private Command createCommand() {
        return this.applicationContext.getBean("command", Command.class);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
