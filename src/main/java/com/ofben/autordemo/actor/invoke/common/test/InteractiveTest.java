package com.ofben.autordemo.actor.invoke.common.test;

import com.ofben.autordemo.actor.invoke.common.interactive.InteractiveCallHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link InteractiveCallHelper} Test
 *
 * @author SL Zhou
 * @date 2021-08-16
 * @since 1.0.0
 */
@Service
public class InteractiveTest {

    @Autowired
    private InteractiveCallHelper call = null;

    public void testCall() {
        // 先处理自己的业务功能

        // 远程调用
        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put("abc", "aa11");
        mapParam.put("paramName", "testName");

        MyRetModel rm = call.call("GoodsModule", "1", mapParam, MyRetModel.class);
        System.out.println("rm ===" + rm);

        // 继续处理自己的业务功能
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        InteractiveTest test = (InteractiveTest) ctx.getBean("interactiveTest");

        test.testCall();
    }
}
