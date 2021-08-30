package com.ofben.autordemo.consistence.test;

import com.ofben.autordemo.actor.invoke.common.interactive.InteractiveCallHelper;
import com.ofben.autordemo.actor.invoke.common.test.InteractiveTest;
import com.ofben.autordemo.consistence.controller.StoreDispatchForInteractiveController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link StoreDispatchForInteractiveController}
 *
 * @date 2021-08-17
 * @since 1.0.0
 */
@Service
public class MyTest {
    @Autowired
    private InteractiveCallHelper call = null;

    public void testCall() {
        // 先处理自己的业务功能

        // 远程调用
        Map<String, Object> mapParam = new HashMap<>();

        mapParam.put("ip", "localhost");
        mapParam.put("port", "9080");
        mapParam.put("url", "/storeDispatchFI/call");

        call.call("GoodsModule", "2", mapParam);

        // 继续处理自己的业务功能
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyTest test = (MyTest) ctx.getBean("myTest");

        test.testCall();
    }
}
