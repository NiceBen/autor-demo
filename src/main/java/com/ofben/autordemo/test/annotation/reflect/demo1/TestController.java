package com.ofben.autordemo.test.annotation.reflect.demo1;

/**
 * {@link MyRequestMapping}
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @see MyRequestMapping
 * @since 1.0.0
 */
@MyRequestMapping("/test")
public class TestController {

    public void test() {
        System.out.println("进入 Test 方法");
    }
}
