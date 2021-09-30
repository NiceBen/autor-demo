package com.ofben.autordemo.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Lookup;

import java.util.Map;

/**
 *
 * @date 2021-09-26
 * @since 1.0.0
 */
public abstract class CommandManager2 {

    public Object process(Map commandState) {
        Command command = createCommand();
        command.setState(commandState);
        return command.execute();
    }

    @Lookup
    public abstract Command createCommand();
}
