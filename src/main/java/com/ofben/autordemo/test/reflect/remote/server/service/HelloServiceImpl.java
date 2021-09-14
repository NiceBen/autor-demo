package com.ofben.autordemo.test.reflect.remote.server.service;

import java.util.Date;

/**
 * {@link HelloService}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String echo(String msg) {
        return "echo-" + msg;
    }

    @Override
    public Date getTime() {
        return new Date();
    }
}
