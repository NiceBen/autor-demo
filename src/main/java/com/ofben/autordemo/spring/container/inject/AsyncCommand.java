package com.ofben.autordemo.spring.container.inject;

/**
 * Bean
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public class AsyncCommand extends Command {
    @Override
    Object execute() {
        System.out.println("execute()");
        return null;
    }
}
