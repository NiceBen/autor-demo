package com.ofben.autordemo.spring.container.inject;

/**
 * Bean
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public abstract class Command {

    private Object commandState;

    public void setCommandState(Object commandState) {
        this.commandState = commandState;
    }

    abstract Object execute();
}
