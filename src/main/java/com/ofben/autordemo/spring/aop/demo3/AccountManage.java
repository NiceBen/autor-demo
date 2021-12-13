package com.ofben.autordemo.spring.aop.demo3;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Component
public class AccountManage {

    public String getAccount(Account account) {
        System.out.println("hello world！ Age:" + account.getAge());
        return "hello world！ Age:" + account.getAge();
    }
}
