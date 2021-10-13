package com.ofben.autordemo.spring.aop.demo2;

/**
 * {@link EchoService}
 *
 * @date 2021-10-13
 * @since 1.0.0
 */
public class DefaultEchoService implements EchoService {
    
    @Override
    public Object echo(String message) {
        return "[Echo] " + message;
    }
}
