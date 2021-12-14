package com.ofben.autordemo.spring.aopapi.demo2;

/**
 * TODO
 *
 * @date 2021-12-14
 * @since TODO
 */
public interface Lockable {
    void lock();
    void unlock();
    boolean locked();
}
