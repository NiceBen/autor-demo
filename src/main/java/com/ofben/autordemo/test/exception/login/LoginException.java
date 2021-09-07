package com.ofben.autordemo.test.exception.login;

/**
 * 定义 {@link Exception} 异常处理类
 *
 * @date 2021-09-07
 * @since 1.0.0
 */
public class LoginException extends Exception {

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }
}
