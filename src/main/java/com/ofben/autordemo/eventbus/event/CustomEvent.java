package com.ofben.autordemo.eventbus.event;

/**
 * 自定义事件类
 *
 * @date 2021-09-22
 * @since 1.0.0
 */
public class CustomEvent {

    private int age;

    public CustomEvent(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
