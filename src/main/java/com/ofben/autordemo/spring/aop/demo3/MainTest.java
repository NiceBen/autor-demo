package com.ofben.autordemo.spring.aop.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AccountManage.class);
        context.register(TestAopAspectJ.class);
        context.refresh();


        AccountManage am = context.getBean(AccountManage.class);
        Account account = new Account();
        account.setName("111");
        System.out.println("am:" + am);

        am.getAccount(account);

        context.close();
    }
}
