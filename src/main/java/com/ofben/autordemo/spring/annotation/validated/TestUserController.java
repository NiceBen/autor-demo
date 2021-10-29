package com.ofben.autordemo.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Test 测试类
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class TestUserController {

    @PostMapping("/test")
    public Object test(@Validated @RequestBody User user) {
        return "hello world";
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestUserController.class);
        context.refresh();

        TestUserController bean = context.getBean(TestUserController.class);
        User user = new User();
        user.setName("zhangsan");
        user.setSex("hh");
        String test = (String) bean.test(user);
        System.out.println(test);
        System.out.println(user);
        context.close();
    }
}
