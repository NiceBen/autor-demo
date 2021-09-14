package com.ofben.autordemo.test.reflect.remote.server.service;

import java.util.Date;

/**
 * {@link Class}
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public interface HelloService {

    String echo(String msg);

    Date getTime();
}
