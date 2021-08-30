package com.ofben.autordemo.optimize.usertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @date 2021-08-27
 * @since 1.0.0
 */
@Service
public class UserService {

    @Autowired
    private UserQueueSender sender;

    public void save(UserModel um) {
        this.sender.sendMsg(um, "OP_Type_Add");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-user-aq.xml");
        UserService t = (UserService) ctx.getBean("userService");

        long a1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            UserModel um = new UserModel();
            um.setUserId("userId" + i);
            um.setName("name" + i);
            um.setAge(i + 5);

            t.save(um);
        }
        long a2 = System.currentTimeMillis();
        System.out.println("time===" + (a2 - a1));
    }

}
