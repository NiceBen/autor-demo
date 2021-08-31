package com.ofben.autordemo;

import com.ofben.autordemo.optimize.usertest.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutorDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {

//        complexTypeTransmit();

        simpleTypeTransmit();
    }

    private static void simpleTypeTransmit() {
        String str = "hello";
        int intArg = 12;

        operationArgs(str, intArg);

        System.out.println("source str = " + str);
        System.out.println("source intArg = " + intArg);
    }

    private static void operationArgs(String str, int intArg) {
        System.out.println("target str = " + str);
        System.out.println("target intArg = " + intArg);
        System.out.println("------------");
        str = "world";
        intArg = 21;
    }

    private static void complexTypeTransmit() {
        UserModel user = new UserModel();
        user.setName("hello");
        operationUser(user);
        System.out.println("user.age=" + user.getAge());
    }

    private static void operationUser(UserModel user) {
        System.out.println("operationUser内：" + user.getName());
        System.out.println("operationUser内：" + user.getAge());
        user.setAge(22);
    }
}
