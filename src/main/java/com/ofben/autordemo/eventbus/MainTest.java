package com.ofben.autordemo.eventbus;

import com.ofben.autordemo.eventbus.event.CustomEvent;
import com.ofben.autordemo.eventbus.listener.EventListener1;
import com.ofben.autordemo.eventbus.listener.EventListener2;
import com.ofben.autordemo.eventbus.util.EventBusUtil;

import java.time.Instant;

/**
 * Main 测试类
 *
 * @date 2021-09-22
 * @since 1.0.0
 */
public class MainTest {

    public static void main(String[] args) {
        EventListener1 listener1 = new EventListener1();
        EventListener2 listener2 = new EventListener2();
        CustomEvent event = new CustomEvent(18);

        EventBusUtil.register(listener1);
        EventBusUtil.register(listener2);

//        EventBusUtil.post(event);
        EventBusUtil.asyncPost(event);
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Instant.now() +",主线程执行完毕："+Thread.currentThread().getName());
    }
}
