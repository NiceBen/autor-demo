package com.ofben.autordemo.test.annotation.reflect.demo2;

import com.ofben.autordemo.test.annotation.reflect.demo1.MyRequestMapping;

/**
 * TODO
 *
 * @date 2021-09-03
 * @since TODO
 */
@MyRequestMapping("/test")
@Person("C")
public class TestController {
    public void test() {
        System.out.println("进入 Test 方法");
    }
}
