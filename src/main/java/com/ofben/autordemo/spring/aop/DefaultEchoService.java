package com.ofben.autordemo.spring.aop;

/**
 * {@link EchoService}
 *
 * @date 2021-10-12
 * @since 1.0.0
 */
public class DefaultEchoService implements EchoService {

    @Override
    public String echo(String message) {
        return "[Echo]" + message;
    }
}
