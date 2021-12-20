package com.ofben.autordemo.spring.aop.demo10;

/**
 * TODO
 *
 * @date 2021-12-20
 * @since TODO
 */
public class TargetMethod {

    @SystemCrmlog(description = "进行了登录操作", tableName = Constans.USER_TABLE_NAME)
    public void test() {
        System.out.println("hello");
    }
}
