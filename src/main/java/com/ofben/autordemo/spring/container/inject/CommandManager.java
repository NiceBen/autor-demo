package com.ofben.autordemo.spring.container.inject;

/**
 * bean
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public abstract class CommandManager {

    public Object process(Object commandState) {
        Command command = createCommand();
        command.setCommandState(commandState);
        System.out.println("command:"+ command);
        return command.execute();
    }

    protected abstract Command createCommand();
}
