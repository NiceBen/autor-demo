package com.ofben.autordemo.test.exception.login;

import java.util.Scanner;

/**
 * 测试主类
 *
 * @date 2021-09-07
 * @since 1.0.0
 */
public class MainTest {

    /*
    Java实例之完善除法运算的错误信息
    http://c.biancheng.net/view/vip_7076.html
     */
    public static void main(String[] args) {

        commonInvoke();

        systemInInvoke();
    }

    private static void commonInvoke() {
        ValidateLogin validateLogin = new ValidateLogin();
        boolean loginFlag = validateLogin.validateLogin("1234567", "12345d");
        System.out.println(loginFlag ? "登录成功！" : "登录失败，请尝试从新登录！");
    }

    private static void systemInInvoke() {
        Scanner input = new Scanner(System.in);
        System.out.println("用户名：");
        String username = input.next();
        System.out.println("密码：");
        String password = input.next();
        ValidateLogin lt = new ValidateLogin();
        boolean con = lt.validateLogin(username,password);    // 调用 validateLogin() 方法
        if (con) {
            System.out.println("登录成功！");
        }
    }
}
