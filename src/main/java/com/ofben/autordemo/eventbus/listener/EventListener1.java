package com.ofben.autordemo.eventbus.listener;

import com.google.common.eventbus.Subscribe;
import com.ofben.autordemo.eventbus.event.CustomEvent;

import java.time.Instant;

/**
 * 事件监听器1
 *
 * @date 2021-09-22
 * @since 1.0.0
 */
public class EventListener1 {

    @Subscribe
    public void test1(CustomEvent event) {
        System.out.println(Instant.now() + "监听者1-->订阅者1，收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void test2(CustomEvent event) {
        System.out.println(Instant.now() + "监听者1-->订阅者2，收到事件：" + event.getAge() + "，线程号为：" + Thread.currentThread().getName());
//        try {
//            Thread.sleep(3 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
