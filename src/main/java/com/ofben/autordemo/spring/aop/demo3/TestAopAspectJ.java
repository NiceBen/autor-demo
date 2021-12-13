package com.ofben.autordemo.spring.aop.demo3;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Component
@Aspect
public class TestAopAspectJ {

        @Pointcut("execution(* com.ofben.autordemo.spring.aop.demo3.AccountManage.*(..)) && args(account,..)")
//    @Pointcut("com.ofben.autordemo.spring.aop.demo3.AccountManage.getAccount() && args(account,..)")
    private void accountDataAccessOperation(Account account) {
    }

    @Before("accountDataAccessOperation(account)")
    public void validateAccount(Account account) {
        account.setAge(18);
        System.out.println("validateAccount：name=" + account.getName());
    }
}
